package fr.dawan.javaintermediare.designspatterns.comportement.state;

/**
 * Interface qui décrit le du Pattern State. Parcourir les différents états de l'objet.
 */
public interface CommandeState {

    void next(Commande cmd);
    void previous(Commande cmd);
    void printState();
}
