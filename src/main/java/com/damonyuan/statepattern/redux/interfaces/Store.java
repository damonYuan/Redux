package com.damonyuan.statepattern.redux.interfaces;

public interface Store<S, R> {
    S getState();

    R getReducer();

    void dispatch(final Action action);

    void addListener(Listener l);

    interface Listener {
        void onUpdate(Long state);
    }
}
