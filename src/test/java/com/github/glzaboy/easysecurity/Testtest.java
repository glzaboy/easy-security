package com.github.glzaboy.easysecurity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
public class Testtest {
    @Test
    @DisplayName("我要测试2")
    public void myTest(){
        assertEquals(true,true);
        System.out.println("abc");
    }
}
