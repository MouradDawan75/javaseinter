package fr.dawan.javaintermediare.designspatterns.structure.adapter;

public class ChargeurNormal {

    public Volt getVolt(){
        return new Volt(10);
    }
}
