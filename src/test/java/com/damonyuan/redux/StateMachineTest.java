package com.damonyuan.redux;

import com.damonyuan.redux.machine.StateContext;
import com.damonyuan.redux.machine.actions.AaaToBbbAction;
import com.damonyuan.redux.machine.actions.BbbToCccAction;
import com.damonyuan.redux.machine.actions.BbbToFinalAction;
import com.damonyuan.redux.machine.actions.CccToFinalAction;
import com.damonyuan.redux.machine.states.AaaState;
import com.damonyuan.redux.machine.states.BbbState;
import com.damonyuan.redux.machine.states.CccState;
import com.damonyuan.redux.machine.states.FinalState;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StateMachineTest implements StateContext.Listener {

    @Test
    public void testStateMachineFlowOne() {
        final StateContext context = new StateContext();
        System.out.println("[MainTest] Current state: " + context.getState().getName());
        context.addListener(this);
        // init state is AaaState
        Assert.assertEquals(AaaState.class.getSimpleName(), context.getState().getName());

        // handle actions: AaaToBbbAction -> BbbToCccAction -> CccToFinalAction
        // handle action: AaaToBbbAction
        context.handle(new AaaToBbbAction());
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // BbbState cannot handle AaaToBbbAction
        context.handle(new AaaToBbbAction());
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // handle action: BbbToCccAction
        final HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("hey", "yo");
        context.handle(new BbbToCccAction(payload));
        Assert.assertEquals(CccState.class.getSimpleName(), context.getState().getName());
        // handle action: CccToFinalAction
        context.handle(new CccToFinalAction());
        Assert.assertEquals(FinalState.class.getSimpleName(), context.getState().getName());
    }

    @Test
    public void testStateMachineFlowTwo() {
        final StateContext context = new StateContext();
        System.out.println("[MainTest] Current state: " + context.getState().getName());
        context.addListener(this);
        // init state is AaaState
        Assert.assertEquals(AaaState.class.getSimpleName(), context.getState().getName());

        // handle actions: AaaToBbbAction -> BbbToFinalAction
        // handle action: AaaToBbbAction
        context.handle(new AaaToBbbAction());
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // BbbState cannot handle AaaToBbbAction
        context.handle(new AaaToBbbAction());
        Assert.assertEquals(BbbState.class.getSimpleName(), context.getState().getName());
        // handle action: BbbToFinalAction
        context.handle(new BbbToFinalAction());
        Assert.assertEquals(CccState.class.getSimpleName(), context.getState().getName());
    }

    @Override
    public void onStateUpdated(final StateContext context) {
        System.out.println("[MainTest] Current state: " + context.getState().getName());
    }
}
