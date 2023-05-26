package com.damonyuan.statepattern.machine;

import com.damonyuan.statepattern.machine.interfaces.Action;
import com.damonyuan.statepattern.machine.interfaces.Context;
import com.damonyuan.statepattern.machine.interfaces.State;
import com.damonyuan.statepattern.machine.states.AaaState;

import java.util.LinkedList;
import java.util.List;

public class MachineContext implements Context {
    private final List<Context.Listener> listeners = new LinkedList<>();
    private State state;

    public MachineContext() {
        state = new AaaState();
    }

    public void addListener(final Context.Listener l) {
        listeners.add(l);
    }

    public void removeListener(final Context.Listener l) {
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
        for (final Context.Listener l : listeners) {
            l.onStateUpdated(this.getState());
        }
    }
}
