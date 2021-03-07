package es.vueling.selenium.domain;


import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Created by sacrists on 26.02.17.
 */
public class ReservationDto {

    private String origin;
    private String destination;
    private String outbound;
    private Integer passengers;

    public ReservationDto() {

    }

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
        return "ReservationDto{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", outbound='" + outbound + '\'' +
                ", passengers=" + passengers +
                '}';
    }

}
