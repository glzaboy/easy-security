//package com.github.glzaboy.easysecurity.session;
//
//import com.github.glzaboy.easysecurity.user.UserImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//public class TestDefaultSession {
//    /**
//     * 会话1
//     */
//    private UuidSession defaultSession;
//    /**
//     * 会话二
//     */
//    private UuidSession defaultSession2;
//    /**
//     * 会话二
//     */
//    private UuidSession defaultSession3;
//    @BeforeEach
//    void testBefore(){
//        UUID sessionId1and2=UUID.randomUUID();
//        UUID sessionId3=UUID.randomUUID();
//        defaultSession=new UuidSession(sessionId1and2);
//        defaultSession2=new UuidSession(sessionId1and2);
//        defaultSession3=new UuidSession(sessionId3);
//    }
//    @Test
//    @DisplayName("测试会话相等")
//    void testEquals(){
//        assertEquals(defaultSession,defaultSession2);
//        assertNotEquals(defaultSession3,defaultSession2);
//    }
//
//
//    @Test
//    @DisplayName("测试会话有效等信息")
//    void  testDefaultSession() throws UnavailableSessionException, InterruptedException {
//        assertEquals(defaultSession.isValid(),true);
//
//
//        assertEquals(defaultSession2.getId(),defaultSession.getId());
//        assertEquals(defaultSession3.getLastActiveDate(),defaultSession3.getCreateDate());
//        Thread.sleep(4);
//        defaultSession3.touch();
//        assertNotEquals(defaultSession3.getLastActiveDate(),defaultSession3.getCreateDate());
//        defaultSession3.stopSession();
//        assertEquals(defaultSession3.isValid(),false);
//
//    }
//    @Test
//    @DisplayName("测试用户相等性")
//    void testDefaultSessionUser() throws UnavailableSessionException {
//        UUID userId=UUID.randomUUID();
//        UserImpl user=new UserImpl(userId);
//        defaultSession.setUser(user);
//        UserImpl user2=new UserImpl(userId);
//        defaultSession2.setUser(user2);
//
//
//
//
//
//
//        assertEquals(defaultSession.getUser(),defaultSession2.getUser());
//        UserImpl user3=new UserImpl(UUID.randomUUID());
//
//        defaultSession3.setUser(user3);
//        assertNotEquals(user,user3);
//        UuidSession locSession=new UuidSession(user3);
//        assertNotEquals(defaultSession3,locSession);
//        assertEquals(defaultSession3.getUser(),locSession.getUser());
//        defaultSession3.setUser(null);
//        assertEquals(defaultSession3.getUser(),null);
//    }
//
//
//
//}
