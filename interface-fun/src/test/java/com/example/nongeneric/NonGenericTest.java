package com.example.nongeneric;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonGenericTest {

    @Test
    public void whenStringNodeWhenStackPushThenReturnsPeek() {
        DataStack stack = new DataStack();

        stack.push(new Person());
        assertEquals("very meta person", stack.peek().getMetadata());
    }
}
