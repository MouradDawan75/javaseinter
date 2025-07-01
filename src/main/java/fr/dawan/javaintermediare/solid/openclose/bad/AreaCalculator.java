package fr.dawan.javaintermediare.solid.openclose.bad;

public class AreaCalculator {

    public double circleArea(Circle c){
        return Math.PI * Math.pow(c.getRadius(), 2);

    }

    public double rectangleArea(Rectangle rec){
        return rec.getHeight() * rec.getWidth();
    }

    //Ajout de la méthode surface d'un triangle: ouverte à l'extension, mais pas fermée la modification

    public double triangleArea(Triangle t){
        return 0;
    }
}

/*
Open/Close: une classe doit être ouverte à l'extension, mais fermée à la modification

L'ajout d'une nouvelle classe Triangle, impique la modification de cette classe -> ajout de la méthode du calcul
de la surface d'un Triangle
 */
