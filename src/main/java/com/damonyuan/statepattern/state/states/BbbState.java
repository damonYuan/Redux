package com.damonyuan.statepattern.state.states;

import com.damonyuan.statepattern.state.AbsState;
import com.damonyuan.statepattern.state.StateContext;

import java.util.Map;

public class BbbState extends AbsState {
    public BbbState(final StateContext context) {
        super(context);
    }

    @Override
    public void onAaaToBbbAction(Map<String, String> payload) {
        // do nothing or throw exception
    }

    @Override
    public void onBbbToCccAction(String payload) {
        System.out.println("  (BbbState) do something in BbbState with BbbToCccAction");
        if (payload != null) {
            System.out.println("  (BbbState) key: " + payload);
        }
        System.out.println("  (BbbState) transit to CccState");
        getContext().setState(new CccState(getContext()));
    }

    @Override
    public void onBbbToFinalAction() {
        System.out.println("  (BbbState) do something in BbbState with BbbToFinalAction");
        System.out.println("  (BbbState) transit to FinalState");
        getContext().setState(new FinalState(getContext()));
    }

    @Override
    public <P> void onCccToFinalAction(P payload) {
        // do nothing or throw exception
    }

    @Override
    public String getName() {
        return BbbState.class.getSimpleName();
    }
}
