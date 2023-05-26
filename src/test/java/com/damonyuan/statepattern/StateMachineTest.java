package com.damonyuan.statepattern;

import com.damonyuan.statepattern.machine.MachineContext;
import com.damonyuan.statepattern.machine.actions.AaaToBbbAction;
import com.damonyuan.statepattern.machine.actions.BbbToCccAction;
import com.damonyuan.statepattern.machine.actions.BbbToFinalAction;
import com.damonyuan.statepattern.machine.actions.CccToFinalAction;
import com.damonyuan.statepattern.machine.interfaces.Context;
import com.damonyuan.statepattern.machine.interfaces.State;
import com.damonyuan.statepattern.machine.states.AaaState;
import com.damonyuan.statepattern.machine.states.BbbState;
import com.damonyuan.statepattern.machine.states.CccState;
import com.damonyuan.statepattern.machine.states.FinalState;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StateMachineTest implements Context.Listener {

    @Test
    public void testStateMachineFlowOne() {
        final MachineContext context = new MachineContext();
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
        final MachineContext context = new MachineContext();
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
        Assert.assertEquals(FinalState.class.getSimpleName(), context.getState().getName());
    }

    @Override
    public void onStateUpdated(final State state) {
        System.out.println("[MainTest] Current state: " + state.getName());
    }
}
