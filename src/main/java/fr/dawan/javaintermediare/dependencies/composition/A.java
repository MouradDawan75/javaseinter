package fr.dawan.javaintermediare.dependencies.composition;
/*
Dépendence de type composition/agrégation
- un type appartient à l'autre
- Ajout de la responsabilité de création et de suppression
- nous impose de connaitre comment l'objet interne B
 */
public class A {

    private B b;

    public A(){
        //A doit savoir comment construire l'objet b
        b = new B("qsdqsd");
    }

    public void methodA(){
        if(b == null){
            b = new B("<wxwx<wx");
            b.methodB();
        }
    }
}
