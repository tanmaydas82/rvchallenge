package com.rv.tour.rest.tranformer;

import com.rv.tour.domain.City;
import com.rv.tour.rest.model.RestCity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tdas on 11/29/15.
 */
public class CityTransformer {

    public static List<RestCity> transform(Page<City> cities) {
        if( cities == null) {
            return null;
        }
        List<RestCity> restCities = new ArrayList<>();
        for(City city : cities) {
            restCities.add(transformACity(city));
        }
        return restCities;
    }

    public static List<RestCity> transform(List<City> cities) {
        if( cities == null || cities.isEmpty()) {
            return null;
        }
        List<RestCity> restCities = new ArrayList<>();
        for(City city : cities) {
            restCities.add(transformACity(city));
        }
        return restCities;
    }
    public static RestCity transformACity(City city) {
        if( city == null ) {
            return null;
        }
        RestCity restCity = new RestCity(city.getId(), city.getCityName(), city.getLongitude(), city.getLatitude(), city.getState().getStateName());
        return restCity;
    }
}
