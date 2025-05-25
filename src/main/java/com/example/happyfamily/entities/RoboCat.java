package com.example.happyfamily.entities;

import com.example.happyfamily.enums.Species;

import java.util.Set;

public class RoboCat extends Pet implements Foulable{

    public RoboCat(Integer age, String nickname, Set<String> habits, Integer trickLevel) {
        super(age, nickname, habits, trickLevel);
        setSpecies(Species.ROBOT_CAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBOT_CAT);
    }

    @Override
    public void respond(Pet pet) {
        if (pet.getNickname() != null) {
            System.out.println("Blitz, blitz. Hello owner. Im - " + pet.getNickname() + ". I miss you!");
        } else {
            System.out.println("Pet you want to describe is missing this fields: Nickname.");
        }
    }

    @Override
    public void foul() {
        System.out.println("Oh, system got crashed for a while! I need to clean home before owner gets home!");
    }
}
