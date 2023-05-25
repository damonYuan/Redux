package com.damonyuan.redux.machine.states;

import com.damonyuan.redux.machine.actions.AaaToBbbAction;
import com.damonyuan.redux.machine.interfaces.Action;
import com.damonyuan.redux.machine.interfaces.Context;
import com.damonyuan.redux.machine.interfaces.State;

import java.util.Map;

public class AaaState implements State {

    @Override
    public String getName() {
        return AaaState.class.getSimpleName();
    }

    @Override
    public void handle(final Context context, final Action action) {
        if (action.getName().equals(AaaToBbbAction.class.getSimpleName())) {
            System.out.println("  (AaaState) do something in AaaState");
            final Map<String, String> payload = ((AaaToBbbAction) action).getPayload();
            System.out.println(
                    "  (AaaState) AaaState should know the payload of the action of this type, it should be null");
            assert payload == null;
            System.out.println("  (AaaState) transit to BbbState");
            context.setState(new BbbState());
        }
    }


}
