package com.damonyuan.statepattern.redux;


import com.damonyuan.statepattern.redux.interfaces.Action;
import com.damonyuan.statepattern.redux.interfaces.Store;

import java.util.LinkedList;
import java.util.List;

public class MyStore implements Store<Long, MyReducer> {
    private final MyReducer reducer = new MyReducer();
    private final List<Listener> listeners = new LinkedList<>();
    private Long state = 1L;

    @Override
    public Long getState() {
        return state;
    }

    @Override
    public MyReducer getReducer() {
        return reducer;
    }

    @Override
    public void dispatch(final Action action) {
        final Long newState = reducer.reduce(state, action);
        this.state = newState;
        for (final Listener l : listeners) {
            l.onUpdate(newState);
        }
    }

    @Override
    public void addListener(final Listener l) {
        listeners.add(l);
    }
}
