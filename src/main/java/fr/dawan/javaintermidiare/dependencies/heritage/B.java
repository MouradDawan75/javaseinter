package fr.dawan.javaintermidiare.dependencies.heritage;

/*
Dépendence de type héritage: niveau de couplage le plus fort
Pb: tout changement dans la classe mère aura une incidence sur toutes les classes filles
 */
public class B extends A{

    public B(int filed1) {
        super(filed1);
    }
}
