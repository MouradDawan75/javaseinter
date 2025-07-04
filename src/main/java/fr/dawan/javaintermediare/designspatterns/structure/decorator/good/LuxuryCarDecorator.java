package fr.dawan.javaintermediare.designspatterns.structure.decorator.good;

public class LuxuryCarDecorator extends CarDecorator{
    public LuxuryCarDecorator(ICar car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();

        System.out.println("Ajout d'options de luxe.............");
    }
}
