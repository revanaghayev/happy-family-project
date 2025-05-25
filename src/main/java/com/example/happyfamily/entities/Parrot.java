package com.example.happyfamily.entities;

import com.example.happyfamily.enums.Species;

import java.util.Set;

public class Parrot extends Pet implements Foulable {

    public Parrot(Integer age, String nickname, Set<String> habits, Integer trickLevel) {
        super(age, nickname, habits, trickLevel);
        setSpecies(Species.PARROT);
    }

    public Parrot(String nickname) {
        super(nickname);
        setSpecies(Species.PARROT);
    }

    @Override
    public void respond(Pet pet) {
        if (pet.getNickname() != null) {
            System.out.println("Hello owner. Im - " + pet.getNickname() + ". I miss you!");
        } else {
            System.out.println("Pet you want to describe is missing this fields: Nickname.");
        }
    }

    @Override
    public void foul() {
        System.out.println("I need to cover seeds up!");
    }
}
