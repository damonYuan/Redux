package com.damonyuan.statepattern.state.states;

import com.damonyuan.statepattern.state.AbsState;
import com.damonyuan.statepattern.state.interfaces.Context;

import java.util.Map;

public class CccState extends AbsState {
    public CccState(Context<AbsState> context) {
        super(context);
    }

    @Override
    public void onAaaToBbbAction(Map<String, String> payload) {
        // do nothing or throw exception
    }

    @Override
    public void onBbbToCccAction(String payload) {
        // do nothing or throw exception
    }

    @Override
    public void onBbbToFinalAction() {
        // do nothing or throw exception
    }

    @Override
    public <P> void onCccToFinalAction(P payload) {
        System.out.println("  (CccState) do something in CccState");
        if (payload instanceof String) {
            System.out.println("  (BbbState) key: " + payload);
        } else if (payload instanceof Map) {
            for (final Map.Entry<String, String> entry : ((Map<String, String>) payload).entrySet()) {
                System.out.println("  (AaaState) key: " + entry.getKey());
                System.out.println("  (AaaState) value: " + entry.getValue());
            }
        }
        System.out.println("  (CccState) transit to FinalState");
        getContext().setState(new FinalState(getContext()));
    }

    @Override
    public String getName() {
        return CccState.class.getSimpleName();
    }
}
