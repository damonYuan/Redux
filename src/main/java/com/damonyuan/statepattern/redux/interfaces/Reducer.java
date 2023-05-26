package com.damonyuan.statepattern.redux.interfaces;

public interface Reducer<S> {
    S reduce(S currentState, Action action);
}
