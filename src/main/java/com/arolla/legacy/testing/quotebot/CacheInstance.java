package com.arolla.legacy.testing.quotebot;

import java.util.Collection;
import java.util.HashMap;

public interface CacheInstance {
    HashMap<String, Collection<String>> getCache();
}
