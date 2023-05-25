package com.damonyuan.redux.states;

import com.damonyuan.redux.machine.Action;
import com.damonyuan.redux.machine.Context;
import com.damonyuan.redux.machine.State;
import com.damonyuan.redux.actions.AaaToBbbAction;

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
            final Map payload = action.getPayload();
            System.out.println("  (AaaState) AaaState should know the payload of the action of this type, it should be null");
            assert payload == null;
            System.out.println("  (AaaState) transit to BbbState");
            context.setState(new BbbState());
        }
    }


}
