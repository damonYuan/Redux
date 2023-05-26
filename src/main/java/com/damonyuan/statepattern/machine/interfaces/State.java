package com.damonyuan.statepattern.machine.interfaces;


public interface State {
    String getName();

    void handle(Context context, Action action);
}
