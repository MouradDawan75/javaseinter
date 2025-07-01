package fr.dawan.javaintermediare.dependencies.association;

/*
Dépendence de type association:
A n'a pas besoin de connaitre le processus de création de l'objet interne. A n'est pas responsabe de son instanciation
 */
public class A {

    private B b;

    public A(B b){
        this.b = b;
    }
}
