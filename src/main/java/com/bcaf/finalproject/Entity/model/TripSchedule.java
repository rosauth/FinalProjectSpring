package com.bcaf.finalproject.Entity.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trip_schedule")
public class TripSchedule {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2",strategy = "uuid2")
    private String id;

    @NotNull
    private String tripDate;

    @NotNull
    private int availableSeats;

    @NotNull
    private String tripDetail;

    @NotNull
    @CollectionTable
    @ElementCollection
    private Set<String> ticketSold;

    public TripSchedule() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTripDate() {
        return tripDate;
    }

    public void setTripDate(String tripDate) {
        this.tripDate = tripDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getTripDetail() {
        return tripDetail;
    }

    public void setTripDetail(String tripDetail) {
        this.tripDetail = tripDetail;
    }

    public Set<String> getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(Set<String> ticketSold) {
        this.ticketSold = ticketSold;
    }
}
