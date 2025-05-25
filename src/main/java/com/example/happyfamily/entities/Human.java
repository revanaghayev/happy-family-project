package com.example.happyfamily.entities;

import com.example.happyfamily.enums.DayOfWeek;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Human implements HumanCreator{

    private String name;
    private String surname;
    private Integer dateOfBirth;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    static {
        System.out.println(Human.class.getName() + " class loaded successfully!");
    }

    {
        System.out.println(this.getClass().getTypeName() + " object created successfully!");
    }

    public Human(String name, String surname, Integer dateOfBirth, int iq, Map<String, String> schedule, Family family) {
        if (dateOfBirth < 1900 || dateOfBirth > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year cannot be lower than 1900 or bigger than current year!");
        }
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        if (iq < 100 && iq > 1) {
            this.iq = iq;
        } else {
            throw new IllegalArgumentException("IQ must be between 1 and 100!");
        }
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, Integer dateOfBirth) {
        if (dateOfBirth < 1900 || dateOfBirth > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year cannot be lower than 1900 or bigger than current year!");
        }
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Human() {
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Hello, " + pet.getNickname());
    }

    public void toDescribeTheFavourite(Pet pet) {
        try {
            System.out.println("I have a " + pet.getSpecies() + " is " + pet.getAge() +
                    " years old, he is " + (pet.getTrickLevel() > 50 ? "very sly." : "almost not sly."));
        } catch (NullPointerException IllegalArgumentException){
            System.out.println("Pet you want to describe is missing this fields: Species, Age, Trick Level.");
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
                    System.out.println("Hmm...I will feed " + name + "'s " + pet.getSpecies() + ".");
                    return true;
                } else {
                    System.out.println("I think Jack is not hungry.");
                    return false;
                }
            }
        } catch (NullPointerException IllegalArgumentException) {
            System.out.println("Pet you want to describe is missing this fields: Species.");
            return false;
        }
    }

    public String ifExists(List<String> namesList, int nameIndex) {
        for (Human child: this.getFamily().getChildren()) {
            if (namesList.get(nameIndex).equalsIgnoreCase(child.getName())){
                return "Undefined name!";
            }
        }
        return namesList.get(nameIndex);
    }

    public void bornChild(Family family) {
        Random randomGenerator = new Random();
        if (family.getFather() != null && family.getMother() != null && !(this instanceof Man) && this.getFamily() != null) {
            List<String > boyNames = List.of("Alexei", "Ivan", "Sergey", "Nikolai", "Dmitriy",
                    "Andrei", "Vladimir", "Yuri", "Pavel", "Mikhail");
            List<String> girlNames = List.of("Anastasia", "Svetlana", "Ekaterina", "Irina", "Olga",
                    "Tatiana", "Natalia", "Maria", "Alina", "Elena");
            int randomNameIndex = randomGenerator.nextInt(10);

            Human boy = new Man(ifExists(boyNames, randomNameIndex), family.getFather().getSurname(), LocalDateTime.now().getYear(),
                    ((family.getFather().getIq() + family.getMother().getIq()) / 2),
                    Map.of(DayOfWeek.MONDAY.name(), "Crying everyday for MILK!"), family);
            Human girl = new Woman(ifExists(girlNames, randomNameIndex), family.getFather().getSurname(), LocalDateTime.now().getYear(),
                    ((family.getFather().getIq() + family.getMother().getIq()) / 2),
                    Map.of(DayOfWeek.MONDAY.name(), "Crying everyday for MILK!"), family);
            Human newBorn = randomGenerator.nextBoolean() ? boy : girl;
            family.addChild(newBorn);
        } else {
            System.out.println("Can't born child, because there's no father or mother!");
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

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq < 100 && iq > 1) {
            this.iq = iq;
        } else {
            System.out.println("IQ must be between 1 and 100!");
        }
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        if (dateOfBirth < 1900 || dateOfBirth > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year cannot be lower than 1900 or bigger than current year!");
        }
        this.dateOfBirth = dateOfBirth;
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
                && Objects.equals(dateOfBirth, human.dateOfBirth)
                && Objects.equals(iq, human.iq)
                && Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth, iq, schedule);
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
        } else if (iq == 0) {
            return "Human:" +
                    " Name = " + name +
                    ", Surname = " + surname +
                    ", Birth date = " + dateOfBirth +
                    ';';
        } else {
            return "Human:" +
                    " Name = " + name +
                    ", Surname= " + surname +
                    ", Birth date = " + dateOfBirth +
                    ", IQ level = " + iq +
                    ", Schedule = " + schedule +
                    ';';
        }
    }
}
