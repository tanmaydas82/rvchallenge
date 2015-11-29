package com.rv.tour.rest.model;

import com.rv.tour.domain.City;

import java.util.Set;

/**
 * Created by Tdas on 11/29/15.
 */
public class RestState {

    private Long Id;
    private String name;
    private String abbreviation;
    private Set<RestCity> cities;

    public RestState() {
    }

    public RestState(Long id, String name, String abbreviation, Set<RestCity> cities) {
        Id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.cities = cities;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Set<RestCity> getCities() {
        return cities;
    }

    public void setCities(Set<RestCity> cities) {
        this.cities = cities;
    }
}
