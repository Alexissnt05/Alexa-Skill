package org.alexis;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class BusArrivalInfo {
    private final BusJsonParser busJsonParser = new BusJsonParser();
    private String busName;
    private long departureTime;

    public BusArrivalInfo() {
        setBusName();
        setDepartureTime();
    }
    public void setBusName() {
        busName = busJsonParser.getJsonNode().get("route_departures").get(0).get("itineraries").get(0).get("headsign").asText();
    }

    public void setDepartureTime() {
        long busDepartureTimeInUnix = busJsonParser.getJsonNode().get("route_departures").get(0).get("itineraries").get(0).get("schedule_items").get(0).get("departure_time").asInt();
        departureTime = ChronoUnit.MINUTES.between(Instant.now(),Instant.ofEpochSecond(busDepartureTimeInUnix));
        //DepartureTime is initialized to the estimated arrival time of a certain bus
    }

    public String getBusName() {
        return busName;
    }

    public long getDepartureTime() {
        return departureTime;
    }
}
