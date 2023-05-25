package com.damonyuan.redux.actions;

import com.damonyuan.redux.Action;

import java.util.Map;

public class BbbToCccAction implements Action<String, String> {
    private final Map<String, String> payload;

    public BbbToCccAction(final Map payload) {
        this.payload = payload;
    }

    @Override
    public String getName() {
        return BbbToCccAction.class.getSimpleName();
    }

    @Override
    public Map<String, String> getPayload() {
        return payload;
    }
}
