package fr.dawan.javaintermediare.designspatterns.comportement.visitor2;

/**
 * Interface qui decrit le rôle des différents objets. Accepter la visite du Visitor
 */
public interface Element {
    void accept(VisitorGeneric v);
}
