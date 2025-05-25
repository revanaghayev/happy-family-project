package com.example.happyfamily.entities;

import com.example.happyfamily.enums.Species;

import java.util.Set;

public class Dog extends Pet implements Foulable {

    public Dog(Integer age, String nickname, Set<String> habits, Integer trickLevel) {
        super(age, nickname, habits, trickLevel);
        setSpecies(Species.DOG);
    }

    public Dog(String nickname) {
        super(nickname);
        setSpecies(Species.DOG);
    }

    @Override
    public void respond(Pet pet) {
        if (pet.getNickname() != null) {
            System.out.println("Woof, woof. Im - " + pet.getNickname() + ". I miss you!");
        } else {
            System.out.println("Pet you want to describe is missing this fields: Nickname.");
        }
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up! Owner can find out that i messed up the room!");
    }
}
