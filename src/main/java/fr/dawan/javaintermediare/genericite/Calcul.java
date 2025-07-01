package fr.dawan.javaintermediare.genericite;

/*
On a la possibilté d'ajouter des contraintes au type T: Calcul<T extends CompteBancaire> - T est une classe fille de CompteBancaire3
                                                        Calcul<T super CompteBancaire> - T est une classe mère de CompteBancaire
                                                        Calcul<T extends IRepository> - T est une classe qui implémente l'interface IRepository
 */

public class Calcul<T> {

    public T a;
    public T b;

    public void swap(){
        T tmp = a;
        a = b;
        b = tmp;
    }
}
