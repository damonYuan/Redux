package com.damonyuan.statepattern.machine.interfaces;

public interface Context {
    interface Listener {
        void onStateUpdated(State state);
    }
    State getState();

    void setState(State state);

    void handle(Action action);
}
