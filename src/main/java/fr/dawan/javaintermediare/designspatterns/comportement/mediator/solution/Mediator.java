package fr.dawan.javaintermediare.designspatterns.comportement.mediator.solution;

/**
 * Classe qui décrit le rôle du pattern Mediator
 * Doit connaitre tous les objets
 * Doit connaitre toutes les interactions entre les différents objets
 */
public class Mediator {

    //connaitre tous les objets
    private Alimentation alimentation;
    private Bouton bouton;
    private Fonction fonction;

    //gérer toutes interactions entre les différents objets

    //Gestion du bouton

    public void press(){
        if(fonction.isOn())
            fonction.turnOff();
        else
            fonction.turnOn();

    }

    //gestion de Fonction
    public void start(){
        alimentation.turnOn();
    }

    public void stop(){
        alimentation.turnOff();
    }
}
