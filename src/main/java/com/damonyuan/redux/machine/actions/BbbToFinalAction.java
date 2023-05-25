package com.damonyuan.redux.machine.actions;

import com.damonyuan.redux.machine.interfaces.Action;

import java.util.HashMap;
import java.util.Map;

public class BbbToFinalAction implements Action<Map<String, String>> {
    private final Map<String, String> map = new HashMap<>();

    @Override
    public String getName() {
        return BbbToFinalAction.class.getSimpleName();
    }

    @Override
    public Map<String, String> getPayload() {
        map.put("key", "BbbToFinalAction");
        return map;
    }
}
