package fr.dawan.javaintermediare.dependencies.relation;

/*
Dépendence de type relation: la plus faible forme de dépendence entre les objets
Limitée dans le temps -> réduite à l'exécution de la methodB -> B utilise de manière temporaire l'objet A
 */
public class B {

    public void methodB(A a){
        a.methodA();
    }
}
