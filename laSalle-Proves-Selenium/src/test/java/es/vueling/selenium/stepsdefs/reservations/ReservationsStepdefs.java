package es.vueling.selenium.stepsdefs.reservations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.vueling.selenium.domain.ReservationDto;
import es.vueling.selenium.pages.ReservationListPage;
import es.vueling.selenium.pages.ReservationPage;
import es.vueling.selenium.services.ReservationService;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Created by sacrists on 26.02.17.
 */
public class ReservationsStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String WEB_ROOT = "https://www.vueling.com/";
    private static final String HOME = "es/";

    @Steps
    private ReservationService reservationService;

    private ReservationPage reservationPage;
    private ReservationListPage reservationListPage;

    private List<ReservationDto> reservations;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
        reservationService.addReservations();
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
        reservationService.clean();
    }

    @Given("I'm main page")
    public void iMInTheReservationsPage() throws Throwable {
        LOGGER.debug("iMInTheReservationsPage starts");

        reservationPage.openAt(WEB_ROOT + HOME);
    }

    @When("I try to find a fly")
    public void iRegisterTheFollowingReservations(List<ReservationDto> reservationDtoList) throws Throwable {
        LOGGER.debug("iRegisterTheFollowingReservations starts");

        reservations = reservationDtoList;
        reservations.forEach(reservation -> reservationListPage.addReservations(reservation));


    }

    @Then("I get available flight")
    public void iGetTheReservationInTheReservationsList() throws Throwable {
        LOGGER.debug("iGetTheReservationInTheReservationsList starts");

        List<ReservationDto> actualReservations = reservationListPage.getReservationList();


        assertThat(actualReservations).as("Reservation list").usingFieldByFieldElementComparator().containsExactlyElementsOf(reservations);
    }
}
