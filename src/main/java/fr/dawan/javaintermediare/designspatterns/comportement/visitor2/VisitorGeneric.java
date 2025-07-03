package fr.dawan.javaintermediare.designspatterns.comportement.visitor2;

/**
 * Interface qui décrit le rôle du Visitor
 * @param <T>: objet à visiter
 * @param <R>: résultat de la visite
 */
public interface VisitorGeneric<T,R> {
    R visit(T obj);
}
