package com.example.nullobject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    @Test
    public void giveUnknownAnimalWhenGetAnimalThenReturnsNullAnimal() {
        Animal animal = AnimalFactory.getAnimal("Unknown");
        Exception exception = assertThrows(NotImplementedException.class, animal::getName);

        assertEquals(exception.getMessage(), "Unknown has not been implemented");
    }
}
