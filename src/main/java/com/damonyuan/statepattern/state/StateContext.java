package com.damonyuan.statepattern.state;


import com.damonyuan.statepattern.state.interfaces.Context;
import com.damonyuan.statepattern.state.states.AaaState;

import java.util.LinkedList;
import java.util.List;

public class StateContext implements Context<AbsState> {
    private final List<Listener<AbsState>> listeners = new LinkedList<>();
    private AbsState state = new AaaState(this);

    @Override
    public AbsState getState() {
        return state;
    }

    @Override
    public void setState(AbsState state) {
        this.state = state;
        for (final Listener<AbsState> l : listeners) {
            l.onStateUpdated(state);
        }
    }

    public void addListener(Listener<AbsState> listener) {
        this.listeners.add(listener);
    }
}
