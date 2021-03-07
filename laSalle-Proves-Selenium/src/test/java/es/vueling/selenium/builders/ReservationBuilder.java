package es.vueling.selenium.builders;

import es.vueling.selenium.domain.Reservation;

public final class ReservationBuilder {

    private String origin;
    private String destination;
    private String outbound;
    private Integer passengers;



    private ReservationBuilder() {
    }

    public static ReservationBuilder aReservation() {
        return new ReservationBuilder();
    }

    public ReservationBuilder withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public ReservationBuilder withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public ReservationBuilder withOutbound(String outbound) {
        this.outbound = outbound;
        return this;
    }

    public ReservationBuilder withPassengers(Integer passengers) {
        this.passengers = passengers;
        return this;
    }


    public Reservation build() {
        Reservation reservation = new Reservation();
        reservation.setOrigin(origin);
        reservation.setDestination(destination);
        reservation.setOutbound(outbound);
        reservation.setPassengers(passengers);
        return reservation;
    }
}
