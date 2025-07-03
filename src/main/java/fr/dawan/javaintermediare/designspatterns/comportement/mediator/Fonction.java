package fr.dawan.javaintermediare.designspatterns.comportement.mediator;

public class Fonction {

    private Bouton bouton;
    private Alimentation alimentation;
    private boolean isOn = false;

    public void turnOn(){
        alimentation.turnOn();
        isOn = true;
    }

    public void turnOff(){
        alimentation.turnOff();
        isOn = false;
    }

    public Bouton getBouton() {
        return bouton;
    }

    public void setBouton(Bouton bouton) {
        this.bouton = bouton;
    }

    public Alimentation getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
