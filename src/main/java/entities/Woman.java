package entities;

public final class Woman extends Human{

    public Woman(String name, String surname, Integer year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public void makeUp() {
        System.out.println("I'm making date makeup for my man!");
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Aww! Hello, my sweet cutie, " + pet.getNickname());
    }
}
