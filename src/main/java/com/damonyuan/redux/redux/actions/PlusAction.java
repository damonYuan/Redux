package com.damonyuan.redux.redux.actions;

import com.damonyuan.redux.redux.interfaces.Action;

public class PlusAction implements Action<Long> {
    private final Long payload;

    public PlusAction(final Long payload) {
        this.payload = payload;
    }

    @Override
    public String getName() {
        return PlusAction.class.getSimpleName();
    }

    @Override
    public Long getPayload() {
        return payload;
    }
}
