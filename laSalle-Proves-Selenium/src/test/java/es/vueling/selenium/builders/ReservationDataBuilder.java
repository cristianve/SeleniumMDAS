package es.vueling.selenium.builders;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDataBuilder {

    public static ReservationBuilder defaultReservation(String origin, String destination,String outbound, Integer passengers) {
        return ReservationBuilder
                .aReservation()
                .withOrigin(origin)
                .withDestination(destination)
                .withOutbound(outbound)
                .withPassengers(passengers);

    }
}
