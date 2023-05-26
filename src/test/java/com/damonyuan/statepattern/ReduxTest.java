package com.damonyuan.statepattern;

import com.damonyuan.statepattern.redux.MyStore;
import com.damonyuan.statepattern.redux.actions.MinusAction;
import com.damonyuan.statepattern.redux.actions.PlusAction;
import com.damonyuan.statepattern.redux.interfaces.Store;
import org.junit.Assert;
import org.junit.Test;

public class ReduxTest implements Store.Listener {
    @Override
    public void onUpdate(final Long state) {
        System.out.println("[MainTest] Current state: " + state);
    }

    @Test
    public void testRedux() {
        final MyStore store = new MyStore();
        System.out.println("[MainTest] Current state: " + store.getState());
        store.addListener(this);
        Assert.assertEquals(1L, store.getState().longValue());

        final PlusAction plusAction = new PlusAction(10L);
        store.dispatch(plusAction);
        Assert.assertEquals(11L, store.getState().longValue());

        final MinusAction minusAction = new MinusAction(3L);
        store.dispatch(minusAction);
        Assert.assertEquals(8L, store.getState().longValue());
    }
}
