package com.github.glzaboy.easysecurity.session;

import com.github.glzaboy.easysecurity.user.DefaultUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestDefaultSession {
    /**
     * 会话1
     */
    private DefaultSession defaultSession;
    /**
     * 会话二
     */
    private DefaultSession defaultSession2;
    /**
     * 会话二
     */
    private DefaultSession defaultSession3;
    @BeforeEach
    void testBefore(){
        UUID sessionId1and2=UUID.randomUUID();
        UUID sessionId3=UUID.randomUUID();
        defaultSession=new DefaultSession(sessionId1and2);
        defaultSession2=new DefaultSession(sessionId1and2);
        defaultSession3=new DefaultSession(sessionId3);
    }
    @Test
    @DisplayName("测试会话相等")
    void testEquals(){
        assertEquals(defaultSession,defaultSession2);
        assertNotEquals(defaultSession3,defaultSession2);
    }


    @Test
    @DisplayName("测试会话有效等信息")
    void  testDefaultSession() throws UnavailableSessionException, InterruptedException {
        assertEquals(defaultSession.isValid(),true);


        assertEquals(defaultSession2.getId(),defaultSession.getId());
        assertEquals(defaultSession3.getLastActiveDate(),defaultSession3.getCreateDate());
        Thread.sleep(4);
        defaultSession3.touch();
        assertNotEquals(defaultSession3.getLastActiveDate(),defaultSession3.getCreateDate());
        defaultSession3.stopSession();
        assertEquals(defaultSession3.isValid(),false);

    }
    @Test
    @DisplayName("测试用户相等性")
    void testDefaultSessionUser() throws UnavailableSessionException {
        UUID userId=UUID.randomUUID();
        DefaultUser user=new DefaultUser(userId);
        defaultSession.setUser(user);
        DefaultUser user2=new DefaultUser(userId);
        defaultSession2.setUser(user2);






        assertEquals(defaultSession.getUser(),defaultSession2.getUser());
        DefaultUser user3=new DefaultUser(UUID.randomUUID());

        defaultSession3.setUser(user3);
        assertNotEquals(user,user3);
        DefaultSession locSession=new DefaultSession(user3);
        assertNotEquals(defaultSession3,locSession);
        assertEquals(defaultSession3.getUser(),locSession.getUser());
        defaultSession3.setUser(null);
        assertEquals(defaultSession3.getUser(),null);
    }



}
