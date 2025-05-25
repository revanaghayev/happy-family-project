package com.example.happyfamily.entities;

import com.example.happyfamily.enums.Species;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable{

    public DomesticCat(Integer age, String nickname, Set<String> habits, Integer trickLevel) {
        super(age, nickname, habits, trickLevel);
        setSpecies(Species.DOMESTIC_CAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.DOMESTIC_CAT);
    }

    @Override
    public void respond(Pet pet) {
        if (pet.getNickname() != null) {
            System.out.println("Meow, meow. Im - " + pet.getNickname() + ". I miss you!");
        } else {
            System.out.println("Pet you want to describe is missing this fields: Nickname.");
        }
    }

    @Override
    public void foul() {
        System.out.println("I need to cover furniture! Owner can find out that i scratched it!");
    }
}
