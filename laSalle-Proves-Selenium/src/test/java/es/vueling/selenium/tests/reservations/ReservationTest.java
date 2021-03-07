package es.vueling.selenium.tests.reservations;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/reservations",
        glue = "es.vueling.selenium.stepsdefs.reservations")
public class ReservationTest extends RunnerBase{


}
