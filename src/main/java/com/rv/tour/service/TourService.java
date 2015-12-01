package com.rv.tour.service;

import com.rv.tour.domain.City;
import com.rv.tour.domain.State;
import com.rv.tour.domain.User;
import com.rv.tour.domain.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourService {

    Page<City> getCitiesInAState(Long stateId, Pageable pageable);

    List<City> getCitiesInAState(Long stateId);

    List<Visit> getPlacesVisitedByAUser(Long userId);

    void removeAPlaceVisitedByAUser(Long userId, Long visitId);

    List<State> getStatesVisitedByAUser(Long userId);

    void addAVisitByAUser(Long userId, String cityName, String stateAbbreviation);

    boolean verifyUserById(Long userId);

    boolean verifyCityNameInState(String cityName, String stateAbbreviation);

    boolean verifyVisitId(Long userId, Long visitId);

    boolean verifyStateId(Long stateId);

//    //CRUD related to USER
//    void createUser(User user);
//
//    User getUserById(Long userId);
//
//    User updateUserById(Long userId);
//
//    void deleteUserById(Long userId);
//
//    //CRUD related to STATE
//    void createState(State state);
//
//    State getStateById(Long stateId);
//
//    State updateStateById(Long stateId);
//
//    void deleteStateById(Long stateId);
//
//    //CRUD related to CITY
//    void createCity(City city);
//
//    City getCityById(Long cityId);
//
//    City updateCityById(Long cityId);
//
//    void deleteCityById(Long cityId);
//
//    //CRUD related to VISIT
//    void createVisit(Visit visit);
//
//    Visit getVisitById(Long visitId);
//
//    Visit updateVisitById(Long visitId);
//
//    void deleteVisitById(Long visitId);

}
