package com.dmslob.spring.core.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TenantScope implements Scope {

    private Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<String, Object>());

    private Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(new HashMap<String, Runnable>());

    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }
        return scopedObjects.get(name);
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    public Object remove(String name) {
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    public String getConversationId() {
        return "tenant";
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}
