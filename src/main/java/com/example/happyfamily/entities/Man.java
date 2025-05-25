package com.example.happyfamily.entities;

import java.util.Map;

public final class Man extends Human{

    public Man() {

    }

    public Man(String name, String surname, Integer dateOfBirth, int iq, Map<String, String> schedule, Family family) {
        super(name, surname, dateOfBirth, iq, schedule, family);
    }

    public Man(String name, String surname, Integer dateOfBirth) {
        super(name, surname, dateOfBirth);
    }

    public void repairCar() {
        System.out.println("I'm repairing this car for going to date with my woman!");
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Hello, my good pet, " + pet.getNickname());
    }
}
