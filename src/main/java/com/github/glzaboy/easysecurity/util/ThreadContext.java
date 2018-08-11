package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.securitymanager.SecurityManager;
import com.github.glzaboy.easysecurity.session.SessionStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class ThreadContext {
    private static final String SECURITY_MANAGER_KEY = ThreadContext.class.getName() + "_SECURITY_MANAGER_KEY";
    private static final String SESSION_STORE_KEY = ThreadContext.class.getName() + "_SESSION_STORE_KEY";
    private static Logger logger = LoggerFactory.getLogger(ThreadLocal.class);
    private static ThreadLocal<Map<String, Object>> threadLocal = new InheritableThreadLocalMap<>();

    static {
        getContext();
    }

    private static Map<String, Object> getContext() {
        Map<String, Object> stringObjectMap = threadLocal.get();
        if (stringObjectMap == null) {
            stringObjectMap = new HashMap<>();
            threadLocal.set(stringObjectMap);
        }
        return stringObjectMap;
    }


    private static Object get(String key) {
        Object o = getContext().get(key);
        if (logger.isTraceEnabled()) {
            logger.debug("Thread {} get key {} of type {} value {}"
                    , Thread.currentThread().getName(), key, o.getClass().getName(), o);
        }
        return o;
    }

    private static void put(String key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("key 不能为空。");
        }
        if (value == null) {
            remove(key);
            return;
        }
        Map<String, Object> stringObjectMap = getContext();
        stringObjectMap.put(key, value);
        if (logger.isTraceEnabled()) {
            logger.trace("Bound value {} of type [{}]  for key [{}] to thread [{}]",
                    value, value.getClass().getName(), key, Thread.currentThread().getName());
        }
    }

    private static Object remove(String key) {
        Map<String, Object> stringObjectMap = getContext();
        Object object = stringObjectMap.remove(key);
        if (object != null && logger.isTraceEnabled()) {
            logger.trace("Removed value of type [{} ] for key [ {}]" + "from thread [{}]"
                    , object.getClass().getName(), key, Thread.currentThread().getName());
        }
        return object;
    }

    public static void removeAll() {
        Map<String, Object> stringObjectMap = getContext();
        stringObjectMap.clear();
        if (logger.isTraceEnabled()) {
            logger.trace("Clean all Bound from thread [{}]",
                    Thread.currentThread().getName());
        }

    }

    public static SecurityManager getSecurityManager() {
        return (SecurityManager) get(SECURITY_MANAGER_KEY);
    }

    public static void setSecurityManager(SecurityManager securityManager) {
        if (securityManager != null) {
            put(SECURITY_MANAGER_KEY, securityManager);
        }
    }

    public static SecurityManager removeSecurityManager() {
        return (SecurityManager) remove(SECURITY_MANAGER_KEY);
    }

    public static SessionStore getSessionStore() {
        return (SessionStore) get(SESSION_STORE_KEY);
    }

    public static void setSessionStore(SessionStore sessionStore) {
        if (sessionStore != null) {
            put(SESSION_STORE_KEY, sessionStore);
        } else {
            removeSessionStore();
        }
    }

    public static SessionStore removeSessionStore() {
        return (SessionStore) remove(SESSION_STORE_KEY);
    }


    private static class InheritableThreadLocalMap<T extends Map<String, Object>> extends InheritableThreadLocal<T> {

    }
}
