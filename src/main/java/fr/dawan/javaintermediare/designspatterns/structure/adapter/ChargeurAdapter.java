package fr.dawan.javaintermediare.designspatterns.structure.adapter;

public interface ChargeurAdapter {

    Volt get4Volts();
    Volt get10Volts();
    Volt get120Volts();
}
