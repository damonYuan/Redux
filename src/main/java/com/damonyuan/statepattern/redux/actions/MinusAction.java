package com.damonyuan.statepattern.redux.actions;

import com.damonyuan.statepattern.redux.interfaces.Action;

public class MinusAction implements Action<Long> {
    private final Long payload;

    public MinusAction(final Long payload) {
        this.payload = payload;
    }

    @Override
    public String getName() {
        return MinusAction.class.getSimpleName();
    }

    @Override
    public Long getPayload() {
        return payload;
    }
}
