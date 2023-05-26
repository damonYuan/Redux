package com.damonyuan.statepattern.machine.states;

import com.damonyuan.statepattern.machine.interfaces.Action;
import com.damonyuan.statepattern.machine.interfaces.Context;
import com.damonyuan.statepattern.machine.interfaces.State;

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
