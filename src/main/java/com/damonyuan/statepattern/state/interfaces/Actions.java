package com.damonyuan.statepattern.state.interfaces;

public interface Actions<C extends Context> {
    C getContext();
}
