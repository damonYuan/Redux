package com.damonyuan.redux;

import com.damonyuan.redux.machine.Action;
import com.damonyuan.redux.machine.Context;
import com.damonyuan.redux.machine.State;
import com.damonyuan.redux.states.AaaState;

import java.util.LinkedList;
import java.util.List;

public class StateContext implements Context {
    private final List<Listener> listeners = new LinkedList<Listener>();
    private State state;
    public StateContext() {
        state = new AaaState();
    }

    public void addListener(final Listener l) {
        listeners.add(l);
    }

    public void removeListener(final Listener l) {
        listeners.remove(l);
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(final State state) {
        this.state = state;
    }

    @Override
    public void handle(final Action action) {
        state.handle(this, action);
        for (final Listener l : listeners) {
            l.onStateUpdated(this);
        }
    }


    interface Listener {
        void onStateUpdated(StateContext context);
    }
}
