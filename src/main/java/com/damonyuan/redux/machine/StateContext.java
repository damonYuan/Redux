package com.damonyuan.redux.machine;

import com.damonyuan.redux.machine.interfaces.Action;
import com.damonyuan.redux.machine.interfaces.Context;
import com.damonyuan.redux.machine.interfaces.State;
import com.damonyuan.redux.machine.states.AaaState;

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


    public interface Listener {
        void onStateUpdated(StateContext context);
    }
}
