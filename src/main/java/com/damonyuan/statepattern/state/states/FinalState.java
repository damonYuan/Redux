package com.damonyuan.statepattern.state.states;

import com.damonyuan.statepattern.state.AbsState;
import com.damonyuan.statepattern.state.StateContext;

import java.util.Map;

public class FinalState extends AbsState {
    public FinalState(final StateContext context) {
        super(context);
    }

    @Override
    public void onAaaToBbbAction(Map<String, String> payload) {
        // do nothing or throw exception
    }

    @Override
    public void onBbbToCccAction(String payload) {
        // do nothing or throw exception
    }

    @Override
    public void onBbbToFinalAction() {
        // do nothing or throw exception
    }

    @Override
    public <P> void onCccToFinalAction(P payload) {
        // do nothing or throw exception
    }

    @Override
    public String getName() {
        return FinalState.class.getSimpleName();
    }
}
