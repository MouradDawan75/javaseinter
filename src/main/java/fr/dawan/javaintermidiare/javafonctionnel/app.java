package fr.dawan.javaintermidiare.javafonctionnel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum Genre{
    MASCULIN,
    FEMININ
}

class Personne{
    private String nom;
    private Genre genre;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Personne(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;
    }

    public Personne() {
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", genre=" + genre +
                '}';
    }
}

public class app {

    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Jean", Genre.MASCULIN));
        personnes.add(new Personne("Marc", Genre.MASCULIN));
        personnes.add(new Personne("Marie", Genre.FEMININ));
        personnes.add(new Personne("Julie", Genre.FEMININ));

        System.out.println(">>>>>>>>>>>>>>> Approche impérative:");

        //Nouvelle liste ne contenant que les personnes de genre féminin
        //Approche impérative: on doit au compilateur ce qu'il doit et comment le faire

        List<Personne> feminins = new ArrayList<>();
        for(Personne p : personnes){
            if(p.getGenre().equals(Genre.FEMININ)){
                feminins.add(p);
            }
        }

        for(Personne p : feminins)
            System.out.println(p);


        System.out.println(">>>>>>>>>>>>>>> Approche déclarative:");
        //Approche déclarative (approche fonctionnelle): on déclare ce qu'on veut au compilateur sans lui dire comment l'obtenir

        personnes.stream()

                .filter(p -> p.getGenre().equals(Genre.FEMININ))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /*
        l'approche fonctionnelle, repose sur l'utilisation d'interfaces fonctionnelles.
        Concept introduit depuis Java (java.util.function)
        Une interface fonctionnelle est une interface qui ne contient qu'une seule méthode à implémenter
         */

        //Comment instancier une interface:

        //Option1: utiliser une classe qui implèmente l'interface
        ICalcul cal1 = new MyCalcul();

        //Option2: utiliser une classe anonyme: syntaxe utilisée dans les Threads et Android
        ICalcul cal2 = new ICalcul() {
            @Override
            public int somme(int x, int y) {
                return x+y;
            }
        };

        //Option3: expression Lambda -> méthode anonyme : (params) -> instructions
        //syntaxe utilisée dans l'api stream

        ICalcul cal3 = (a,b) -> a + b;

        //Option4: méthode réference
        //syntaxe utilisée dans l'api stream

        Tools t = new Tools();

        ICalcul cal4 = t::addition; //réference vers une méthode d'instance

        ICalcul ca5 = Tools::soustraction; //réference vers une méthode statique




    }
}
