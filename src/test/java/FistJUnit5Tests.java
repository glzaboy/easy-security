import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FistJUnit5Tests {
    @BeforeAll
    static void before(){
        System.out.println("BEfore");
    }


    @Test
    @DisplayName("我要测试")
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
    @Test
    @DisplayName("我要测试2")
    void myFirstTest2() {
        assertEquals(2, 1 + 1);
    }
}
