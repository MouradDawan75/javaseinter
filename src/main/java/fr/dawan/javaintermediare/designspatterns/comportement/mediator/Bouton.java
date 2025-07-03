package fr.dawan.javaintermediare.designspatterns.comportement.mediator;

public class Bouton {

    private Fonction fonction;

    public void press(){
        if(fonction.isOn())
            fonction.turnOff();
        else
            fonction.turnOn();
    }
}
