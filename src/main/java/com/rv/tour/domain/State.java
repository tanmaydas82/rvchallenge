package com.rv.tour.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="state")
public class State implements Serializable {

    @Id
    @Column(name = "state_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_abbreviation")
    private String abbreviation;

    public State() {
    }

    public State(String stateName, String abbreviation) {
        this.abbreviation = abbreviation;
        this.stateName = stateName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "State{" +
                "Id=" + Id +
                ", stateName='" + stateName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
