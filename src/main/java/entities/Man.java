package entities;

public class Man extends Human{

    public void repairCar() {
        System.out.println("I'm repairing this car for going to date with my woman!");
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Hello, my good boy, " + pet.getNickname());
    }
}
