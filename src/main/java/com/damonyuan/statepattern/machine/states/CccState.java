package com.damonyuan.statepattern.machine.states;

import com.damonyuan.statepattern.machine.actions.CccToFinalAction;
import com.damonyuan.statepattern.machine.interfaces.Action;
import com.damonyuan.statepattern.machine.interfaces.Context;
import com.damonyuan.statepattern.machine.interfaces.State;

import java.util.Map;

public class CccState implements State {
    @Override
    public String getName() {
        return CccState.class.getSimpleName();
    }

    @Override
    public void handle(final Context context, final Action action) {
        if (action.getName().equals(CccToFinalAction.class.getSimpleName())) {
            System.out.println("  (CccState) do something in CccState");
            final Map payload = ((CccToFinalAction) action).getPayload();
            if (payload != null) {
                System.out.println("  (CccState) CccToFinalAction payload is not null");
            } else {
                System.out.println("  (CccState) CccToFinalAction payload is null");
            }
            System.out.println("  (CccState) transit to FinalState");
            context.setState(new FinalState());
        }
    }
}
