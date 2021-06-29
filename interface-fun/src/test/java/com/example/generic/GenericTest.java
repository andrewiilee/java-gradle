package com.example.generic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenericTest {

    @Test
    public void whenStringNodeWhenStackPushThenReturnsPeek() {
        Stack<String> stringStack = new Stack<>();

        stringStack.push("Some String");
        assertEquals("Some String", stringStack.peek());
    }
}
