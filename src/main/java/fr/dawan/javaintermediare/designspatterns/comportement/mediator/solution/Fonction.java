package fr.dawan.javaintermediare.designspatterns.comportement.mediator.solution;

public class Fonction {

    private Mediator mediator;

    private boolean isOn = false;

    public void turnOn(){
        isOn = true;
        mediator.start();
    }

    public void turnOff(){
        isOn = false;
        mediator.stop();
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
