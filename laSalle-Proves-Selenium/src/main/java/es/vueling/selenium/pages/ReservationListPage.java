package es.vueling.selenium.pages;

import es.vueling.selenium.domain.ReservationDto;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.thucydides.core.pages.components.HtmlTable.inTable;

/**
 * Created by sacrists on 26.02.17.
 */

public class ReservationListPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ReservationPage reservationPage;

    private WebElementFacade origenSelector;
    private WebElementFacade destinationSelector;
    private WebElementFacade passengersSelector;

    public void addReservations(ReservationDto reservation) {
        // btnAdd.click();
        reservationPage.registerReservation(reservation);
    }

    public List<ReservationDto> getReservationList() {
        LOGGER.debug("getReservationList starts");
        ReservationDto reservationDto = new ReservationDto();

        origenSelector = find(By.cssSelector("#newStv > div:nth-child(7) > div > div.vy-journey_header > h3"));
        String origen = origenSelector.getText().substring(0, origenSelector.getText().indexOf(' '));
        reservationDto.setOrigin(origen);

        destinationSelector = find(By.cssSelector("#newStv > div:nth-child(8) > div > div.vy-journey_header > h3"));
        String destination = destinationSelector.getText().substring(0, destinationSelector.getText().indexOf(' '));
        reservationDto.setDestination(destination);

        //TODO
        reservationDto.setOutbound("NEXT_WEEK");


        passengersSelector = find(By.cssSelector("#newSearchContainer > div > p:nth-child(2)"));
        String passengers = passengersSelector.getText().substring(passengersSelector.getText().indexOf('|'));

        passengers = passengers.substring(2, passengers.indexOf(" Pasajero"));
        LOGGER.debug(passengers);

        reservationDto.setPassengers(Integer.parseInt(passengers));


        List<ReservationDto> reservations = new ArrayList<>();
        reservations.add(reservationDto);
        return reservations;
    }

    private ReservationDto mapReservation(Map<Object, String> rowMap) {
        ReservationDto reservation = new ReservationDto();
        reservation.setOrigin(rowMap.get("Origin"));
        reservation.setDestination(rowMap.get("Destination"));
        reservation.setOutbound(rowMap.get("Outbound"));
        reservation.setPassengers(Integer.parseInt(rowMap.get("Passengers")));

        return reservation;
    }
}
