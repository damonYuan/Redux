package com.damonyuan.redux;

public interface State {
    String getName();

    void handle(Context context, Action action);
}
