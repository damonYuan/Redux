package com.damonyuan.redux;

import java.util.Map;

public interface Action<K, V> {
    String getName();

    Map<K, V> getPayload();
}
