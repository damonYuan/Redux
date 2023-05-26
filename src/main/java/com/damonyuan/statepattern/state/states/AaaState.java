package com.damonyuan.statepattern.state.states;

import com.damonyuan.statepattern.state.AbsState;
import com.damonyuan.statepattern.state.interfaces.Context;

import java.util.Map;

public class AaaState extends AbsState {

    public AaaState(Context<AbsState> context) {
        super(context);
    }

    @Override
    public void onAaaToBbbAction(Map<String, String> payload) {
        System.out.println("  (AaaState) do something in AaaState");
        if (payload != null) {
            for (final Map.Entry<String, String> entry : payload.entrySet()) {
                System.out.println("  (AaaState) key: " + entry.getKey());
                System.out.println("  (AaaState) value: " + entry.getValue());
            }
        }
        System.out.println("  (AaaState) transit to BbbState");
        getContext().setState(new BbbState(getContext()));
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
        // do nothing or throw exception
    }


    @Override
    public String getName() {
        return AaaState.class.getSimpleName();
    }
}
