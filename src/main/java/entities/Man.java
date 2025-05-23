package entities;

public final class Man extends Human{

    public Man(String name, String surname, Integer year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public void repairCar() {
        System.out.println("I'm repairing this car for going to date with my woman!");
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Hello, my good pet, " + pet.getNickname());
    }
}
