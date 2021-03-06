package com.rv.tour.controller;

import com.rv.tour.Exception.ResourceNotFoundException;
import com.rv.tour.domain.City;
import com.rv.tour.domain.State;
import com.rv.tour.domain.User;
import com.rv.tour.domain.Visit;
import com.rv.tour.rest.tranformer.CityTransformer;
import com.rv.tour.rest.tranformer.VisitTransformer;
import com.rv.tour.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TourController {

    private static Logger logger = LoggerFactory.getLogger(TourController.class);

    @Autowired
    private TourService tourService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/user/{userId}/visits", method = RequestMethod.POST)
    public ResponseEntity<?> createVisitedCity(@PathVariable("userId") Long userId,
                                               @RequestBody Map<String, String> cityAndState) {

        logger.info("Inside createVisitedCity : {}", userId);

        String city = cityAndState.get("city");
        String state = cityAndState.get("state");
        if( !tourService.verifyUserById(userId) ) {
            throw new ResourceNotFoundException("User with id " + userId + " not found.");
        }
        if(!tourService.verifyCityNameInState(city, state)) {
            throw new ResourceNotFoundException("City " + city + " and " + state + " combination not found.");
        }
        tourService.addAVisitByAUser(userId, city, state);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/user/{userId}/visit/{visitId}", method = RequestMethod.DELETE)
    public ResponseEntity<?>  removeAPlaceVisitedByAUser(@PathVariable("userId") Long userId,
                                      @PathVariable("visitId") Long visitId) {

        logger.info("Inside removeAPlaceVisitedByAUser : {}", userId);

        if( !tourService.verifyUserById(userId) ) {
            throw new ResourceNotFoundException("User with id " + userId + " not found.");
        }
        if(!tourService.verifyVisitId(userId, visitId)) {
            throw new ResourceNotFoundException("Visit " + visitId + " does not belong to user " + userId + ".");
        }
        tourService.removeAPlaceVisitedByAUser(userId, visitId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/user/{userId}/visits", method = RequestMethod.GET)
    public ResponseEntity<?> getPlacesVisitedByAUser(@PathVariable("userId") Long userId) {
        if( !tourService.verifyUserById(userId) ) {
            throw new ResourceNotFoundException("User with id " + userId + " not found.");
        }
        List<Visit> visits = tourService.getPlacesVisitedByAUser(userId);

        return new ResponseEntity<>(VisitTransformer.tranform(visits), null, HttpStatus.OK);
    }

    @RequestMapping(value="/user/{userId}/visits/states", method = RequestMethod.GET)
    public ResponseEntity<?> getVisitedStates(@PathVariable("userId") Long userId) {
        if( !tourService.verifyUserById(userId) ) {
            throw new ResourceNotFoundException("User with id " + userId + " not found.");
        }
        List<State> states = tourService.getStatesVisitedByAUser(userId);

        return new ResponseEntity<>(states, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/state/{stateId}/cities", method= RequestMethod.GET)
    public ResponseEntity<?> getCitiesInAState(@PathVariable("stateId") Long stateId, Pageable pageable) {
        if( !tourService.verifyStateId(stateId)) {
            throw new ResourceNotFoundException("State with id " + stateId + " not found.");
        }
        Page<City> cities =  tourService.getCitiesInAState(stateId, pageable);
        return new ResponseEntity<>(CityTransformer.transform(cities), null, HttpStatus.OK);
    }

}
