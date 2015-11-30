package com.rv.tour.service;

import com.rv.tour.domain.City;
import com.rv.tour.domain.State;
import com.rv.tour.domain.User;
import com.rv.tour.repository.CityRepository;
import com.rv.tour.repository.StateRepository;
import com.rv.tour.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Tdas on 11/28/15.
 */
@Component
@Transactional
public class InternalServiceImpl implements InternalService {

    private static Logger logger = LoggerFactory.getLogger(InternalServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;


    @Override
    public void saveUser(String firstName, String lastName) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(firstName+lastName+"@tour.com");
        User user = new User(firstName,
                    lastName,
                    firstName.substring(0,2) + lastName.substring(0,2),
                     password);
        userRepository.save(user);
    }

    @Override
    public void saveState(String name, String abbraviation) {
        State state = new State(name, abbraviation);
        stateRepository.save(state);
    }

    @Override
    public void saveCity(String name, Long stateId, Double latitude, Double longitude, String status) {
        State state = stateRepository.findOne(stateId);
        City city = new City(name, status, state, latitude, longitude);
        cityRepository.save(city);
    }
}
