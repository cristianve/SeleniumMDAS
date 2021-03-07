package es.vueling.selenium.pages;

import es.vueling.selenium.domain.ReservationDto;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Created by sacrists on 26.02.17.
 */

public class ReservationPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    // Form
    private WebElementFacade ensCloseBanner;
    private WebElementFacade origenSelector;
    private WebElementFacade input;
    private WebElementFacade btnSubmitHomeSearcher;

    Logger log = LoggerFactory.getLogger(ReservationPage.class);

    public void registerReservation(ReservationDto reservation) {
        LOGGER.debug("registerReservation starts, reservation: [{}]", reservation);


        log.info("Banner Cookie Close!!");
        ensCloseBanner.click();
        origenSelector = find(By.cssSelector("#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.origin > div > input"));
        origenSelector.click();

        input = find(By.cssSelector("#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.origin.focused-bottom-arrow > vy-airports-popup-list > div.searchbar-popup_header > div.searchbar-popup_header_search > input"));
        input.sendKeys(reservation.getOrigin());

        find(By.cssSelector("#popup-list > vy-airports-li > li > p:nth-child(1)")).click();

        input = find(By.cssSelector("#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.destination.focused-bottom-arrow > vy-airports-popup-list > div.searchbar-popup_header > div.searchbar-popup_header_search > input"));
        input.sendKeys(reservation.getDestination());
        find(By.cssSelector("#popup-list > vy-airports-li > li > p:nth-child(1)")).click();


        find(By.cssSelector(" #searchbar > div > vy-datepicker-popup > div > span")).click();


        btnSubmitHomeSearcher.click();

    }


}
