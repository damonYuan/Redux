package com.damonyuan.redux.actions;

import com.damonyuan.redux.machine.Action;

import java.util.HashMap;
import java.util.Map;

public class BbbToFinalAction implements Action<String, String> {
    private final Map<String, String> map = new HashMap<String, String>();

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
