package com.damonyuan.redux;

public interface Context {
    State getState();

    void setState(State state);

    void handle(Action action);
}
