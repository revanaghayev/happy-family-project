package entities;

public class Woman extends Human{

    public void makeUp() {
        System.out.println("I'm making date makeup for my man!");
    }

    public void toWelcomeTheFavourite(Pet pet) {
        System.out.println("Hello, my sweet cutie, " + pet.getNickname());
    }
}
