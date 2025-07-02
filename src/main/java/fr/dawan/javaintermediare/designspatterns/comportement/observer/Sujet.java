package fr.dawan.javaintermediare.designspatterns.comportement.observer;

/**
 * Interface qui décrit le rôle du Sujet dans le Pattern Observer.
 * Son rôle est de gérer une liste d'observer et de leur envoyer une notification si un événement se produit concernant
 * l'objet qu'ils observent
 * @param <T>
 */
public interface Sujet<T> {
    void attach(Observer<T> o);
    void detach(Observer<T> o);
    void notify(T o);
}
