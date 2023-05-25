package com.damonyuan.redux.redux;

import com.damonyuan.redux.redux.actions.MinusAction;
import com.damonyuan.redux.redux.actions.PlusAction;
import com.damonyuan.redux.redux.interfaces.Action;
import com.damonyuan.redux.redux.interfaces.Reducer;

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
