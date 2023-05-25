package com.damonyuan.redux.states;

import com.damonyuan.redux.machine.Action;
import com.damonyuan.redux.machine.Context;
import com.damonyuan.redux.machine.State;

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
