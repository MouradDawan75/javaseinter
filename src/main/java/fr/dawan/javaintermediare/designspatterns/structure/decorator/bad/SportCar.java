package fr.dawan.javaintermediare.designspatterns.structure.decorator.bad;

public class SportCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Adding sport options.............");
    }
}
