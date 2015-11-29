package com.rv.tour.domain;

import javax.persistence.*;

@Entity
@Table(name="visit")
public class Visit {

    @Id
    @Column(name = "visit_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    public Visit(User user, City city) {
        this.user = user;
        this.city = city;
    }

    public Visit() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "Id=" + Id +
                ", user=" + user +
                ", city=" + city +
                '}';
    }
}
