package com.damonyuan.redux.actions;

import com.damonyuan.redux.Action;

import java.util.Map;

public class AaaToBbbAction implements Action {

    @Override
    public String getName() {
        return AaaToBbbAction.class.getSimpleName();
    }

    @Override
    public Map getPayload() {
        return null;
    }
}
