package com.example.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericTest {

    @Test
    public void whenStringNodeWhenStackPushThenReturnsPeek() {
        Stack<String> stringStack = new Stack<>();

        stringStack.push("Some String");
        assertEquals("Some String", stringStack.peek());
    }
}
