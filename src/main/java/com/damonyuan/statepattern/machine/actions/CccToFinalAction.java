package com.damonyuan.statepattern.machine.actions;

import com.damonyuan.statepattern.machine.interfaces.Action;

import java.util.Map;

public class CccToFinalAction implements Action<Map<String, String>> {
    @Override
    public String getName() {
        return CccToFinalAction.class.getSimpleName();
    }

    @Override
    public Map<String, String> getPayload() {
        return null;
    }
}
