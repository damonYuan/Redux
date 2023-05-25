package com.damonyuan.redux.redux.actions;

import com.damonyuan.redux.redux.interfaces.Action;

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
