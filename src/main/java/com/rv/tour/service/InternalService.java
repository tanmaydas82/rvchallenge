package com.rv.tour.service;

/**
 * Created by Tdas on 11/28/15.
 */
public interface InternalService {

    void saveUser(String firstName, String lastName);

    void saveState(String name, String abbraviation);

    void saveCity(String name, Long stateId, Double latitude, Double longitude, String status);
}
