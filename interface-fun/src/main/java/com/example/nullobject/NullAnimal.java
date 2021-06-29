package com.example.nullobject;

public class NullAnimal implements Animal {
    private final String name;

    public NullAnimal (String name) {
        this.name = name;
    }

    public String getName() {
        throw new NotImplementedException(name);
    }
}
