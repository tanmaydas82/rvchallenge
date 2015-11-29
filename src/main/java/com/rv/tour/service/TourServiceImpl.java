package com.rv.tour.service;

import com.rv.tour.domain.City;
import com.rv.tour.domain.State;
import com.rv.tour.domain.User;
import com.rv.tour.domain.Visit;
import com.rv.tour.repository.CityRepository;
import com.rv.tour.repository.StateRepository;
import com.rv.tour.repository.UserRepository;
import com.rv.tour.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TourServiceImpl implements TourService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public boolean verifyCityNameInState(String cityName, String stateAbbreviation) {
        List<State>  states = stateRepository.findStateByAbbreviation(stateAbbreviation);
        if( states.isEmpty() ) {
            return false;
        } else {
            List<City> cities = cityRepository.findByState(states.get(0));
            cities = cities.stream().filter(city->city.getCityName().equalsIgnoreCase(cityName)).collect(Collectors.toList());
            if( cities.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean verifyUserById(Long userId) {
        User user = userRepository.findOne(userId);
        return user != null;
    }

    @Override
    public boolean verifyVisitId(Long userId, Long visitId) {
        User user = userRepository.findOne(userId);
        List<Visit> visits = visitRepository.findByUser(user);
        visits = visits.stream().filter(visit -> visit.getId().equals(visitId)).collect(Collectors.toList());
        return !visits.isEmpty();
    }

    @Override
    public boolean verifyStateId(Long stateId) {
        State state = stateRepository.findOne(stateId);
        return state != null;
    }

    @Override
    public List<City> getCitiesInAState(Long stateId) {
        State state = stateRepository.findOne(stateId);
        return cityRepository.findByState(state);
    }

    @Override
    public List<Visit> getPlacesVisitedByAUser(Long userId) {
        User user = userRepository.findOne(userId);
        return visitRepository.findByUser(user);
    }

    @Override
    public void removeAPlaceVisitedByAUser(Long userId, Long visitId) {
        visitRepository.delete(visitId);
    }

    @Override
    public List<State> getStatesVisitedByAUser(Long userId) {
        User user = userRepository.findOne(userId);
        List<Visit> cities = visitRepository.findByUser(user);

        Set<Long> keys = new HashSet<>();
        List<State> states = new LinkedList<>();
        cities.stream().forEach(visit -> {
            if( !keys.contains(visit.getCity().getState().getId()) ) {
                keys.add(visit.getCity().getState().getId());
                states.add(visit.getCity().getState());
            }
        });

        return states;
    }

    @Override
    public void addAVisitByAUser(Long userId, String cityName, String stateAbbreviation) {
        User user = userRepository.findOne(userId);
        City city = cityRepository.findCityByNameAndStateAbbreviation(cityName, stateAbbreviation);
        Visit visit = new Visit();
        visit.setCity(city);
        visit.setUser(user);
        visitRepository.save(visit);

    }

}
