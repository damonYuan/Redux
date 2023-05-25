package com.damonyuan.redux.machine.interfaces;

public interface Context {
    State getState();

    void setState(State state);

    void handle(Action action);
}
