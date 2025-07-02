package fr.dawan.javaintermediare.designspatterns.creation.singleton;

public class Pdg {;

    private String name;
    private static Pdg instance;

    public String getName() {
        return name;
    }

    //Vérrouiller l'accès au constructeur par défaut
    private Pdg(){

    }

    //Gestion des accès concurrentiels à la ressource instance
    public static synchronized Pdg getInstance(String name){
        if(instance == null){
            instance = new Pdg();
        }
        instance.name = name;

        return instance;
    }
}
