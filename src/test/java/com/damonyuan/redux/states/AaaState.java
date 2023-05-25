package com.damonyuan.redux.states;

import com.damonyuan.redux.Action;
import com.damonyuan.redux.Context;
import com.damonyuan.redux.State;
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
            System.out.println("do something in AaaState");
            final Map payload = action.getPayload();
            System.out.println("AaaState should know the payload of the action of this type, it should be null");
            assert payload == null;
            System.out.println("transit to BbbState");
            context.setState(new BbbState());
        }
    }


}
