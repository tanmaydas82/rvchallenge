package com.rv.tour.rest.model;

import com.rv.tour.domain.Visit;

import java.util.Set;

/**
 * Created by Tdas on 11/29/15.
 */
public class RestUser {
    private Long Id;
    private String firstName;
    private String lastName;

    private Set<RestCity> visits;

    public RestUser() {
    }

    public RestUser(Long id, String firstName, String lastName, Set<RestCity> visits) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.visits = visits;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Set<RestCity> getVisits() {
        return visits;
    }

    public void setVisits(Set<RestCity> visits) {
        this.visits = visits;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
