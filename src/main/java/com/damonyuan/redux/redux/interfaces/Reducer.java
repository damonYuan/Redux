package com.damonyuan.redux.redux.interfaces;

public interface Reducer<S> {
    S reduce(S currentState, Action action);
}
