package fr.dawan.javaintermediare.designspatterns.comportement.visitor;

/**
 * Interface qui décrit le pattern Visitor
 */
public interface Visitor {
    void Visit(Rectangle rec);
    void Visit(Cercle c);
}
