package com.damonyuan.redux.machine.actions;

import com.damonyuan.redux.machine.interfaces.Action;

import java.util.Map;

public class AaaToBbbAction implements Action<Map<String, String>> {

    @Override
    public String getName() {
        return AaaToBbbAction.class.getSimpleName();
    }

    @Override
    public Map<String, String> getPayload() {
        return null;
    }
}
