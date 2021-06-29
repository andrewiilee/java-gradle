package com.example.nullobject;

public class AnimalFactory {

    public static Animal getAnimal(String name) {
        if (name.equals("Cow")) {
            return new Cow();
         } else if (name.equals("Dog")) {
            return new Dog();
        } else {
            return new NullAnimal(name);
        }
    }
}
