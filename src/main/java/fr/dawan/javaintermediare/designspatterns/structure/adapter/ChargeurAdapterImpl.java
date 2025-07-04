package fr.dawan.javaintermediare.designspatterns.structure.adapter;

import fr.dawan.javaintermediare.polymorphisme.C;

public class ChargeurAdapterImpl implements ChargeurAdapter{

    private ChargeurNormal chargeur = new ChargeurNormal();

    @Override
    public Volt get4Volts() {
        Volt v = chargeur.getVolt();
        return convert(v, 55);
    }

    @Override
    public Volt get10Volts() {
        Volt v = chargeur.getVolt();
        return convert(v, 11);
    }

    @Override
    public Volt get120Volts() {
        Volt v = chargeur.getVolt();
        return convert(v, 2);
    }

    private Volt convert(Volt v, int i){
        return new Volt(v.getVolt() / i);
    }
}
