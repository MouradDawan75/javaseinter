package fr.dawan.javaintermediare.designspatterns.structure.decorator.good;

public class SportCarDecorator extends CarDecorator {

    public SportCarDecorator(ICar car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding sports options............");
    }
}
