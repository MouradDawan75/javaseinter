package fr.dawan.javaintermediare.solid.openclose.good;

public class Circle implements IForme{

    private double radius;

    @Override
    public double calculArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
