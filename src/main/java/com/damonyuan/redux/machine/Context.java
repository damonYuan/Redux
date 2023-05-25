package com.damonyuan.redux.machine;

public interface Context {
    State getState();

    void setState(State state);

    void handle(Action action);
}
