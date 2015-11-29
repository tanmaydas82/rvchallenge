package com.rv.tour.rest.model;

/**
 * Created by Tdas on 11/29/15.
 */
public class RestCity {

    private Long Id;
    private String name;
    private Double longitude;
    private Double latitude;

    public RestCity() {
    }

    public RestCity(Long id, String name, Double longitude, Double latitude) {
        Id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
