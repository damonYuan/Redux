package com.damonyuan.statepattern.machine.actions;

import com.damonyuan.statepattern.machine.interfaces.Action;

import java.util.Map;

public class BbbToCccAction implements Action<Map<String, String>> {
    private final Map<String, String> payload;

    public BbbToCccAction(final Map<String, String> payload) {
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
