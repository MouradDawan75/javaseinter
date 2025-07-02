package fr.dawan.javaintermediare.designspatterns.comportement.observer;

/**
 * Interface qui décrit le rôle de l'observer dans le Pattern Observer.
 * Son rôle est de réagir par rapport à la fotif. transmise par le sujet (l'objet qu'il observe)
 * @param <T>
 */
public interface Observer<T> {
    void update(T o);
}
