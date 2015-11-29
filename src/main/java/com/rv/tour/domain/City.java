package com.rv.tour.domain;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name="city_name")
    private String cityName;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public City() {
    }

    public City(String cityName,
                String status,
                State state,
                Double latitude,
                Double longitude) {
        this.cityName = cityName;
        this.status = status;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "Id=" + Id +
                ", cityName='" + cityName + '\'' +
                ", status='" + status + '\'' +
                ", state=" + state +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
