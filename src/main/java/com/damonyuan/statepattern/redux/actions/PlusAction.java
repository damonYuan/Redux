package com.damonyuan.statepattern.redux.actions;

import com.damonyuan.statepattern.redux.interfaces.Action;

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
