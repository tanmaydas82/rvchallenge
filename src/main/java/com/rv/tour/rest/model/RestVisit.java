package com.rv.tour.rest.model;

/**
 * Created by Tdas on 11/29/15.
 */
public class RestVisit {

    private Long Id;
    private String place;
    private Double longitude;
    private Double latitude;

    public RestVisit() {
    }

    public RestVisit(Long id, String place, Double longitude, Double latitude) {
        Id = id;
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
