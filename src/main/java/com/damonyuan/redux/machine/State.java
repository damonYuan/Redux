package com.damonyuan.redux.machine;

public interface State {
    String getName();

    void handle(Context context, Action action);
}
