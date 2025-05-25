package com.example.happyfamily.entities;

import java.util.Map;

public final class Woman extends Human {

    public Woman() {

    }

    public Woman(String name, String surname, Integer dateOfBirth, int iq, Map<String, String> schedule, Family family) {
        super(name, surname, dateOfBirth, iq, schedule, family);
    }

    public Woman(String name, String surname, Integer dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    public void makeUp() {
        System.out.println("I'm making date makeup for my man!");
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Aww! Hello, my sweet cutie, " + pet.getNickname());
    }
}
