package com.github.glzaboy.easysecurity.util;

import com.github.glzaboy.easysecurity.securitymanager.DefaultSecurityManager;
import com.github.glzaboy.easysecurity.session.DefaultSessionStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestThreadContext {
    @Test
    void TestThreadContext(){
        assertNull(ThreadContext.getSecurityManager()) ;
        DefaultSecurityManager uuiduuidDefaultSecurityManager = new DefaultSecurityManager();
        ThreadContext.setSecurityManager(uuiduuidDefaultSecurityManager);
        assertEquals(ThreadContext.getSecurityManager(), uuiduuidDefaultSecurityManager);
        assertEquals(ThreadContext.removeSecurityManager(), uuiduuidDefaultSecurityManager);
        assertNull(ThreadContext.getSecurityManager());
        ThreadContext.setSecurityManager(uuiduuidDefaultSecurityManager);
        ThreadContext.removeAll();
        assertNull(ThreadContext.getSecurityManager());
        assertNull(ThreadContext.getSessionStore());
        DefaultSessionStore uuiduuidDefaultSessionStore = new DefaultSessionStore();
        ThreadContext.setSessionStore(uuiduuidDefaultSessionStore);
        assertEquals(ThreadContext.getSessionStore(), uuiduuidDefaultSessionStore);
        assertEquals(ThreadContext.removeSessionStore(), uuiduuidDefaultSessionStore);
        assertNull(ThreadContext.getSessionStore());
        ThreadContext.setSessionStore(uuiduuidDefaultSessionStore);
        ThreadContext.removeAll();
        assertNull(ThreadContext.getSessionStore());
        ThreadContext.setSessionStore(uuiduuidDefaultSessionStore);
        ThreadContext.setSecurityManager(uuiduuidDefaultSecurityManager);
        assertEquals(uuiduuidDefaultSecurityManager, ThreadContext.getSecurityManager());
        assertEquals(uuiduuidDefaultSessionStore, ThreadContext.getSessionStore());
        ThreadContext.setSecurityManager(null);
        ThreadContext.setSessionStore(null);
        assertNull(ThreadContext.getSessionStore());
        assertNull(ThreadContext.getSecurityManager());


    }
}
