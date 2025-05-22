package entities;

import enums.Species;

public class DomesticCat extends Pet implements Foulable{

    private final Species species;

    public DomesticCat(Integer age, String nickname, String[] habits, Byte trickLevel) {
        super(age, nickname, habits, trickLevel);
        this.species = Species.DOMESTIC_CAT;
    }

    public DomesticCat(String nickname) {
        super(nickname);
        this.species = Species.DOMESTIC_CAT;
    }

    @Override
    public void respond(Pet pet) {
        if (pet.getNickname() != null) {
            System.out.println("Meow, meow. Im - " + pet.getNickname() + ". I miss you!");
        } else {
            System.out.println("Pet you want to describe is missing this fields: Nickname");
        }
    }

    @Override
    public void foul() {
        System.out.println("I need to cover furniture! Owner can find out that i scratched it!");
    }
}
