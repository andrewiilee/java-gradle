package com.example.nongeneric;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonGenericTest {

    @Test
    public void whenStringNodeWhenStackPushThenReturnsPeek() {
        DataStack stack = new DataStack();

        stack.push(new Person());
        assertEquals("very meta person", stack.peek().getMetadata());
    }
}
