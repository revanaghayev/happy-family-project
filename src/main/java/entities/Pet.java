package entities;

import enums.Species;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {

    private Species species;
    private String nickname;
    private Integer age;
    private Integer trickLevel;
    private Set<String> habits;

    static {
        System.out.println("Pet object loaded!");
    }

    {
        System.out.println("Pet object created!");
    }

    public Pet(Integer age, String nickname, Set<String > habits, Integer trickLevel) {
        this.species = Species.UNKNOWN;
        this.age = age;
        this.nickname = nickname;
        this.habits = habits;
        if (trickLevel < 100 && trickLevel > 1) {
            this.trickLevel = trickLevel;
        } else {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    public Pet(String nickname) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
    }

    public Pet() {
    }

    public void eat() {
        System.out.println("Im eating!");
    }

    public abstract void respond(Pet pet);

    public void foul() {

    }
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        if (trickLevel < 100 && trickLevel > 1) {
            this.trickLevel = trickLevel;
        } else {
            System.out.println("Invalid trick level. Please try again!");
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age < 0) throw new IllegalArgumentException("Age can't be lower than 0!");
        this.age = age;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet pet)) return false;
        return Objects.equals(species, pet.species)
                && Objects.equals(nickname, pet.nickname)
                && Objects.equals(age, pet.age)
                && Objects.equals(trickLevel, pet.trickLevel)
                && Objects.deepEquals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, habits);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("This object has been deleted!");
        super.finalize();
    }

    @Override
    public String toString() {
        if (species == null) {
            return "All fields are empty!";
        } else if (age == null) {
            return species + ":" +
                    " Nickname = " + nickname +
                    " Characteristics = {" + (species.canFly ? "Can fly," : "Can't fly,") +
                    " Number of legs: " + species.numberOfLegs +
                    (species.hasFur ? "Has fur}" : "Has not any fur}") +
                    ';';
        } else {
            return species + ":" +
                    " Nickname = " + nickname +
                    ", Age = " + age +
                    ", TrickLevel = " + trickLevel +
                    ", Habits = " + habits +
                    " Characteristics = {" + (species.canFly ? "Can fly," : "Can't fly,") +
                    " Number of legs: " + species.numberOfLegs +
                    (species.hasFur ? "Has fur}" : "Has not any fur}") +
                    ';';
        }
    }
}
