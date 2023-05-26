package com.damonyuan.statepattern.redux;

import com.damonyuan.statepattern.redux.actions.MinusAction;
import com.damonyuan.statepattern.redux.actions.PlusAction;
import com.damonyuan.statepattern.redux.interfaces.Action;
import com.damonyuan.statepattern.redux.interfaces.Reducer;

public class MyReducer implements Reducer<Long> {
    @Override
    public Long reduce(final Long currentState, final Action action) {
        if (action.getName().equals(PlusAction.class.getSimpleName())) {
            return currentState + ((PlusAction) action).getPayload();
        } else if (action.getName().equals(MinusAction.class.getSimpleName())) {
            return currentState - ((MinusAction) action).getPayload();
        } else {
            return currentState;
        }
    }
}
