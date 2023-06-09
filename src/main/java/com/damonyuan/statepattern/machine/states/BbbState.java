package com.damonyuan.statepattern.machine.states;

import com.damonyuan.statepattern.machine.actions.BbbToCccAction;
import com.damonyuan.statepattern.machine.actions.BbbToFinalAction;
import com.damonyuan.statepattern.machine.interfaces.Action;
import com.damonyuan.statepattern.machine.interfaces.Context;
import com.damonyuan.statepattern.machine.interfaces.State;

import java.util.Map;

public class BbbState implements State {
    @Override
    public String getName() {
        return BbbState.class.getSimpleName();
    }

    @Override
    public void handle(final Context context, final Action action) {
        if (action.getName().equals(BbbToCccAction.class.getSimpleName())) {
            System.out.println("  (BbbState) do something in BbbState with BbbToCccAction");
            final Map<String, String> payload = ((BbbToCccAction) action).getPayload();
            if (payload != null) {
                for (final Map.Entry<String, String> entry : payload.entrySet()) {
                    System.out.println("  (BbbState) key: " + entry.getKey());
                    System.out.println("  (BbbState) value: " + entry.getValue());
                }
            }
            System.out.println("  (BbbState) transit to CccState");
            context.setState(new CccState());
        } else if (action.getName().equals(BbbToFinalAction.class.getSimpleName())) {
            System.out.println("  (BbbState) do something in BbbState with BbbToFinalAction");
            final Map<String, String> payload = ((BbbToFinalAction) action).getPayload();
            if (payload != null) {
                for (final Map.Entry<String, String> entry : payload.entrySet()) {
                    System.out.println("  (BbbState) key: " + entry.getKey());
                    System.out.println("  (BbbState) value: " + entry.getValue());
                }
            }
            System.out.println("  (BbbState) transit to FinalState");
            context.setState(new FinalState());
        }
    }
}
