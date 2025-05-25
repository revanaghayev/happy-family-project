package com.example.happyfamily.console;

import com.example.happyfamily.entities.*;
import com.example.happyfamily.enums.DayOfWeek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class FamilyApp {

    public static void main(String[] args) {

        Pet pet1 = new Dog("Rex");
        Pet pet2 = new DomesticCat(6, "Puss",
                new HashSet<>(Arrays.asList("Scratching", "Eating", "Smiling")), 20);
        Pet pet3 = new Dog("Jack");
        Pet pet4 = new Fish("Fishy");
        Human mother = new Woman("Sveta", "Mamedova", 1970);
        Human father = new Man();
        Family ourFamily = new Family(mother, father);
        Human son = new Human("Maxim", "Mamedov", 2004, 90,
                Map.of(DayOfWeek.MONDAY.name(), "Workout", DayOfWeek.TUESDAY.name(), "Running"), ourFamily);
        Human daughter1 = new Woman("Natasha", "Mamedova", 2001);
        Human daughter2 = new Woman("Natasha", "Mamedova", 2001);
        Human daughter3 = new Woman("Natasha", "Mamedova", 2001);

        Human p1 = new Human();
        Human p2 = new Human();
        Human p3 = null;


//        Testing equals/hashCode contract
//        System.out.println(daughter2.equals(daughter1));
//        System.out.println(daughter2.hashCode() == daughter1.hashCode());
//        System.out.println(daughter2.equals(daughter3));
//        System.out.println(daughter1.equals(daughter3));


//        Checking finalize method (if currently GC works or not)
//        for (int i = 1; i < 10000; i++) {
//            new Human();
//            System.gc();
//        }

        son.toWelcomeTheFavourite(pet1);
        son.toFeedTheFavourite(true, pet2);
        son.toDescribeTheFavourite(pet1);
        pet1.eat();
        pet3.foul();
        pet4.foul();
        System.out.println(pet2.getHabits());
        pet1.respond(pet3);

        System.out.println(pet1.toString());
        System.out.println(son.toString());

        System.out.println(son.getSchedule());
        System.out.println(ourFamily.addChild(son));
        System.out.println(ourFamily.addChild(daughter1));
        System.out.println(ourFamily.deleteChild(son));
        System.out.println(ourFamily.deleteChild(son));


        System.out.println(ourFamily.addChild(null));
        System.out.println(ourFamily.countFamily());

        System.out.println(ourFamily.getChildren());
    }
}
