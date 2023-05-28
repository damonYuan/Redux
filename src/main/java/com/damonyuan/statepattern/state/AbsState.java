package com.damonyuan.statepattern.state;


import com.damonyuan.statepattern.state.interfaces.Actions;
import com.damonyuan.statepattern.state.interfaces.State;

import java.util.Map;

public abstract class AbsState implements State, Actions<StateContext> {
    private final StateContext context;

    public AbsState(StateContext context) {
        this.context = context;
    }

    @Override
    public StateContext getContext() {
        return context;
    }

    public abstract void onAaaToBbbAction(Map<String, String> payload);
    public abstract void onBbbToCccAction(String payload);
    public abstract void onBbbToFinalAction();
    public abstract <P> void onCccToFinalAction(P payload);

}
