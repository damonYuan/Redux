package com.damonyuan.redux.machine.states;

import com.damonyuan.redux.machine.interfaces.Action;
import com.damonyuan.redux.machine.interfaces.Context;
import com.damonyuan.redux.machine.interfaces.State;

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
