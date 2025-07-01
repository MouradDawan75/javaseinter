package fr.dawan.javaintermediare.solid.liskovsubstitution.good;

public class app {

    public static void main(String[] args) {
        TransportationDevice parent = new Car();
        parent.startMoving();

        parent = new Bicycle();
        parent.startMoving();
    }
}
