package com.damonyuan.redux.states;

import com.damonyuan.redux.Action;
import com.damonyuan.redux.Context;
import com.damonyuan.redux.State;

public class FinalState implements State {
    @Override
    public String getName() {
        return FinalState.class.getSimpleName();
    }

    @Override
    public void handle(final Context context, final Action action) {
        // do nothing
    }
}
