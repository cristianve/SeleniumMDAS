package es.vueling.selenium.services;

import es.vueling.selenium.builders.ReservationDataBuilder;
import es.vueling.selenium.domain.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sacrists on 26.02.17.
 * <p>
 * Class to interact with the API of the application and, for example, add reservations to later use them from the UI
 */
public class ReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public Reservation addReservations() {
        LOGGER.debug("addReservations starts, creating [{}]");


        // TODO interact with the API of the application (in this case this app is an example)
        Reservation reservation = generateReservations();
        LOGGER.debug(reservation.toString());
        return reservation;
    }


    private Reservation generateReservations() {

        return new ReservationDataBuilder().defaultReservation("Almería", "Alicante", "NEXT_WEEK", 1).build();
    }


    public void clean() {
        LOGGER.debug("clean");

        // TODO interact with the API of the application (in this case this app is an example)
    }
}
