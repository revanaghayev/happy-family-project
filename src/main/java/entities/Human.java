package entities;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {

    private String name;
    private String surname;
    private Integer year;
    private Byte iq;
    private String[][] schedule;
    private Family family;

    static {
        System.out.println("Human object loaded!");
    }

    {
        System.out.println("Human object created!");
    }

    public Human(String name, String surname, Integer year, Byte iq, String[][] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        if (iq < 100 && iq > 1) {
            this.iq = iq;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human() {
    }

    public Boolean contains(Human human, Human[] children) {
        for (int i = 0; i < children.length; i++) {
            if (children[i].equals(human)) {
                return true;
            }
        }
        return false;
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Hello, " + pet.getNickname());
    }

    public void toDescribeTheFavourite(Pet pet) {
        try {
            System.out.println("I have a " + pet.getSpecies() + " is " + pet.getAge() +
                    " years old, he is " + (pet.getTrickLevel() > 50 ? "very sly." : "almost not sly."));
        } catch (NullPointerException IllegalArgumentException){
            System.out.println("Pet you want to describe is missing this fields: Species, Age, Trick Level");
        }
    }

    public Boolean toFeedTheFavourite(boolean isItTimeForFeeding, Pet pet) {
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(99)+1;
        try {
            if (isItTimeForFeeding) {
                System.out.println("Hmm...I will feed " + name + "'s " + pet.getSpecies());
                return true;
            } else {
                if (pet.getTrickLevel() > randomNumber) {
                    System.out.println("Hmm...I will feed " + name + "'s " + pet.getSpecies());
                    return true;
                } else {
                    System.out.println("I think Jack is not hungry.");
                    return false;
                }
            }
        } catch (NullPointerException IllegalArgumentException) {
            System.out.println("Pet you want to describe is missing this fields: Species");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Byte getIq() {
        return iq;
    }

    public void setIq(Byte iq) {
        if (iq < 100 && iq > 1) {
            this.iq = iq;
        } else {
            System.out.println("Invalid input!");
        }
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(name, human.name)
                && Objects.equals(surname, human.surname)
                && Objects.equals(year, human.year)
                && Objects.equals(iq, human.iq)
                && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, Arrays.deepHashCode(schedule));
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("This object has been deleted!");
        super.finalize();
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Empty Human";
        } else if (iq == null) {
            return "Human:" +
                    " Name = " + name +
                    ", Surname = " + surname +
                    ", Birth year = " + year +
                    ';';
        } else {
            return "Human:" +
                    " Name = " + name +
                    ", Surname= " + surname +
                    ", Birth year = " + year +
                    ", IQ level = " + iq +
                    ", Schedule = " + Arrays.deepToString(schedule) +
                    ';';
        }
    }
}
