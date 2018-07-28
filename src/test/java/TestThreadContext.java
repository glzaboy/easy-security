import com.github.glzaboy.easysecurity.securitymanager.DefaultSecurityManager;
import com.github.glzaboy.easysecurity.securitymanager.SecurityManager;
import com.github.glzaboy.easysecurity.util.ThreadContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestThreadContext {
    @Test
    void TestThreadContext(){
        assertNull(ThreadContext.getSecurityManager()) ;
        SecurityManager securityManager=new DefaultSecurityManager();
        ThreadContext.setSecurityManager(securityManager);
        assertEquals(ThreadContext.getSecurityManager(),securityManager);
        assertEquals(ThreadContext.removeSecurityManager(),securityManager);
        assertNull(ThreadContext.getSecurityManager());
        ThreadContext.setSecurityManager(securityManager);
        ThreadContext.removeAll();
        assertNull(ThreadContext.getSecurityManager());
    }
}
