package com.rv.tour.rest.tranformer;

import com.rv.tour.domain.Visit;
import com.rv.tour.rest.model.RestCity;
import com.rv.tour.rest.model.RestUser;
import com.rv.tour.rest.model.RestVisit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tdas on 11/29/15.
 */
public class VisitTransformer {

    public static List<RestVisit> tranform(List<Visit> visits) {
        if( visits == null || visits.isEmpty()) {
            return null;
        }
        RestUser restUser = new RestUser();
        List<RestVisit> restVisits = new ArrayList<>();

        for(Visit visit : visits) {
            restVisits.add(new RestVisit(visit.getId(), visit.getCity().getCityName(),
                    visit.getCity().getLongitude(), visit.getCity().getLatitude()));
        }

        return restVisits;
    }
}
