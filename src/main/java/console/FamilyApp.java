package console;

import entities.*;
import enums.DayOfWeek;
import enums.Species;

import java.util.Arrays;

public class FamilyApp {

    public static void main(String[] args) {

        Pet pet1 = new Dog(Species.DOG, "Rex");
        Pet pet2 = new DomesticCat(6, "Kisa",
                new String[]{"Scratching", "Eating", "Smiling"}, (byte) 20);
        Pet pet3 = new Dog(Species.DOG, "Pitty");
        Human mother = new Human("Sveta", "Mamedova", 1970);
        Human father = new Human();
        Family ourFamily = new Family(mother, father);
        Human son = new Human("Maxim", "Mamedov", 2004, (byte) 90,
                new String[][]{{DayOfWeek.MONDAY.name(), "Workout"}, {DayOfWeek.TUESDAY.name(), "Running"}},
                ourFamily);
        Human daughter1 = new Human("Natasha", "Mamedova", 2001);
        Human daughter2 = new Human("Natasha", "Mamedova", 2001);
        Human daughter3 = new Human("Natasha", "Mamedova", 2001);

        Human p1 = new Human();
        Human p2 = new Human();
        Human p3 = null;

        System.out.println(daughter2.equals(daughter1));
        System.out.println(daughter2.hashCode() == daughter1.hashCode());
        System.out.println(daughter2.equals(daughter3));
        System.out.println(daughter1.equals(daughter3));


        //Checking finalize method (if currently GC works or not)
//        for (int i = 1; i < 10000; i++) {
//            new Human();
//            System.gc();
//        }

//        son.toWelcomeTheFavourite(pet1);
//        son.toFeedTheFavourite(true, pet2);
//        pet1.eat();
//        pet3.foul();
//        System.out.println(pet2.getHabits());
//        pet1.respond(pet3);

        System.out.println(pet1.toString());
        System.out.println(son.toString());

        System.out.println(ourFamily.addChild(son));
        System.out.println(ourFamily.addChild(daughter1));
        System.out.println(ourFamily.deleteChild(son));
        System.out.println(ourFamily.deleteChild(son));


        System.out.println(ourFamily.addChild(null));
        System.out.println(ourFamily.countFamily());

        System.out.println(Arrays.toString(ourFamily.getChildren()));
    }
}
