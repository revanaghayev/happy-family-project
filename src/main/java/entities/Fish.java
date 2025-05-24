package entities;

import enums.Species;

import java.util.Set;

public class Fish extends Pet{

    private final Species species;

    public Fish(Integer age, String nickname, Set<String> habits, Integer trickLevel) {
        super(age, nickname, habits, trickLevel);
        this.species = Species.FISH;
    }

    public Fish(String nickname) {
        super(nickname);
        this.species = Species.FISH;
    }

    @Override
    public void respond(Pet pet) {
        if (pet.getNickname() != null) {
            System.out.println("Glub, glub. Im - " + pet.getNickname());
        } else {
            System.out.println("Pet you want to describe is missing this fields: Nickname");
        }
    }
}
