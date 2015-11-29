package com.rv.tour.rest.tranformer;

import com.rv.tour.domain.State;
import com.rv.tour.rest.model.RestState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tdas on 11/29/15.
 */
public class StateTranformer {
    public static List<RestState> transform(List<State> states) {
        List<RestState> restStates = new ArrayList<>();

        for(State state : states) {
            RestState restState = new RestState();
            restState.setId(state.getId());
            restState.setName(state.getStateName());
            restState.setAbbreviation(state.getAbbreviation());

            restStates.add(restState);
        }
        return restStates;
    }
}
