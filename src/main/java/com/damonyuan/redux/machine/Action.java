package com.damonyuan.redux.machine;

import java.util.Map;

public interface Action<K, V> {
    String getName();

    Map<K, V> getPayload();
}
