package com.damonyuan.statepattern.state.interfaces;


public interface Context<S extends State> {
    S getState();

    void setState(S state);

    interface Listener<S extends State> {
        void onStateUpdated(S state);
    }
}
