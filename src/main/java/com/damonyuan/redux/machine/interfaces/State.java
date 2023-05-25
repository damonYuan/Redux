package com.damonyuan.redux.machine.interfaces;

public interface State {
    String getName();

    void handle(Context context, Action action);
}
