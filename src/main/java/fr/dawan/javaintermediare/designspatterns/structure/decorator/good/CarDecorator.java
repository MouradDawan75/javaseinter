package fr.dawan.javaintermediare.designspatterns.structure.decorator.good;

/**
 * Classe qui décrit le rôle du pattern Decorator
 */
public class CarDecorator implements ICar{
    private ICar car;

    public CarDecorator(ICar car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}
