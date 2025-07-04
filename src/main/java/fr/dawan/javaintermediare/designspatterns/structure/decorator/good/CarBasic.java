package fr.dawan.javaintermediare.designspatterns.structure.decorator.good;

public class CarBasic implements ICar{
    @Override
    public void assemble() {
        System.out.println("Basic car....");
        /*
        monter le chasis
        ajouter les portes - les roues
         */
    }
}
