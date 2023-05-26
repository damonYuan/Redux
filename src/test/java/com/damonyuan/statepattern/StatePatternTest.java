package com.damonyuan.statepattern;

import com.damonyuan.statepattern.state.AbsState;
import com.damonyuan.statepattern.state.StateContext;
import com.damonyuan.statepattern.state.interfaces.Context;
import com.damonyuan.statepattern.state.states.AaaState;
import com.damonyuan.statepattern.state.states.BbbState;
import com.damonyuan.statepattern.state.states.CccState;
import com.damonyuan.statepattern.state.states.FinalState;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StatePatternTest implements Context.Listener<AbsState> {

    @Test
    public void testStateMachineFlowOne() {
        final StateContext context = new StateContext();
        System.out.println("[StatePatternTest] Current state: " + context.getState().getName());
        context.addListener(this);
        // init state is AaaState
        Assert.assertEquals(AaaState.class.getSimpleName(), context.getState().getName());

        // handle actions: AaaToBbbAction -> BbbToCccAction -> CccToFinalAction
        // handle action: AaaToBbbAction
        final HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("hey", "yo");
        context.getState().onAaaToBbbAction(payload);
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // BbbState cannot handle AaaToBbbAction
        context.getState().onAaaToBbbAction(payload);
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // handle action: BbbToCccAction
        context.getState().onBbbToCccAction("Hello");
        Assert.assertEquals(CccState.class.getSimpleName(), context.getState().getName());
        // handle action: CccToFinalAction
        context.getState().onCccToFinalAction("Bye");
        Assert.assertEquals(FinalState.class.getSimpleName(), context.getState().getName());
    }

    @Test
    public void testStateMachineFlowTwo() {
        final StateContext context = new StateContext();
        System.out.println("[StatePatternTest] Current state: " + context.getState().getName());
        context.addListener(this);
        // init state is AaaState
        Assert.assertEquals(AaaState.class.getSimpleName(), context.getState().getName());

        // handle actions: AaaToBbbAction -> BbbToFinalAction
        // handle action: AaaToBbbAction
        final HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("hey", "yo");
        context.getState().onAaaToBbbAction(payload);
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // BbbState cannot handle AaaToBbbAction
        context.getState().onAaaToBbbAction(payload);
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // handle action: BbbToFinalAction
        context.getState().onBbbToFinalAction();
        Assert.assertEquals(FinalState.class.getSimpleName(), context.getState().getName());
    }

    @Override
    public void onStateUpdated(AbsState state) {
        System.out.println("[StatePatternTest] Current state: " + state.getName());
    }
}
