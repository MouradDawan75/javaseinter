package fr.dawan.javaintermediare.solid.openclose.good;

public class Rectangle implements IForme{

    private double width;
    private double height;


    @Override
    public double calculArea() {
        return width * height;
    }
}
