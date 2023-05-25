package com.damonyuan.redux.actions;

import com.damonyuan.redux.machine.Action;

import java.util.Map;

public class CccToFinalAction implements Action {
    @Override
    public String getName() {
        return CccToFinalAction.class.getSimpleName();
    }

    @Override
    public Map getPayload() {
        return null;
    }
}
