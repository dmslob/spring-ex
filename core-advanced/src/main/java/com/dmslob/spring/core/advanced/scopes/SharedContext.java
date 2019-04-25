package com.dmslob.spring.core.advanced.scopes;

import java.util.HashMap;
import java.util.Map;

/**
 * Sample class which provides access to some legacy storage, not spring-aware.
 */
public class SharedContext {

    // imitates the shared context
    private static Map<String, Object> m = new HashMap<>();

    public static Map<String, Object> get() {
        // imagine, some complicated logic of obtaining the shared context goes here
        return m;
    }
}
