package com.arolla.legacy.testing.quotebot;

import java.util.Collection;
import java.util.HashMap;

public class CacheInstanceImpl implements CacheInstance {

    private static HashMap<String, Collection<String>> cache = new HashMap<>();

    @Override
    public HashMap<String, Collection<String>> getCache() {
        return cache;
    }
}
