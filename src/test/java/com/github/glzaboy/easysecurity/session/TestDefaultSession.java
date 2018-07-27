package com.github.glzaboy.easysecurity.session;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestDefaultSession {
    private static DefaultSession defaultSession;
    @BeforeAll
    static void testBefore(){
        defaultSession=new DefaultSession();
    }

    @Test
    void  testDefaultSession() throws InterruptedException {
        assertEquals(defaultSession.isValid(),true);
        UUID uuid=UUID.randomUUID();
        defaultSession.setId(uuid);
        assertEquals(uuid,defaultSession.getId());
        DefaultSession defaultSession1=new DefaultSession();
        defaultSession1.setId(uuid);
        Date date=new Date();
        defaultSession1.setLastActiveDate(date);
        defaultSession.setLastActiveDate(date);
        assertEquals(defaultSession1.getLastActiveDate(),date);

        assertEquals(defaultSession1,defaultSession);
        defaultSession.touch();
        Thread.sleep(10);
        defaultSession1.touch();
        assertNotEquals(defaultSession1,defaultSession);


    }

}
