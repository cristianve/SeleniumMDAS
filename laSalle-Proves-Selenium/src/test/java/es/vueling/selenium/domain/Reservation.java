package es.vueling.selenium.domain;


import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {

    private String origin;
    private String destination;
    private String outbound;
    private Integer passengers;


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOutbound() {
        return outbound;
    }

    public void setOutbound(String outbound) {
        this.outbound = outbound;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", outbound='" + outbound + '\'' +
                ", passengers=" + passengers +
                '}';
    }


}
