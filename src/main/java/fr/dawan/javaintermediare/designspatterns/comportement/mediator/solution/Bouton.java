package fr.dawan.javaintermediare.designspatterns.comportement.mediator.solution;

public class Bouton {

    private Mediator mediator;

    public void press(){
        mediator.press();
    }
}
