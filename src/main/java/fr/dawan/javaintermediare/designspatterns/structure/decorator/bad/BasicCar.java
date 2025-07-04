package fr.dawan.javaintermediare.designspatterns.structure.decorator.bad;

public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("Basic car....");
        /*
        monter le chasis
        ajouter les portes - les roues
         */
    }
}
