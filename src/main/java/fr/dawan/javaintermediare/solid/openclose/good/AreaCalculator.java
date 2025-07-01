package fr.dawan.javaintermediare.solid.openclose.good;

public class AreaCalculator {

    public double areaCalculator(IForme forme){
        return forme.calculArea();
    }
}

/*
Classe qui respecte le open/close
Solution: utilisation du polymorphisme
 */