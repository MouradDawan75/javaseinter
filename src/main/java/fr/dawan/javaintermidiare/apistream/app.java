package fr.dawan.javaintermidiare.apistream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class app {
    public static void main(String[] args) throws Exception {
        /*
        Api Stream: repose sur l'utilisation des interfaces fonctionnelles fournies dans le package java.util.function.
        Elle permet d'effectuer des opérations sur une source de données (filter, transformer....), de récupérer le résultat final
        sans modifier la source de départ.
         */

        //Charger les données dans l'api stream
        //A partir d'une liste de constantes: Stream.of (la liste des constantes)
        Stream<String> valeursConstantes = Stream.of("a1", "a2", "a3");

        // A partir d'un tableau
        String[] tableau = {"a1","a2","a3"};
        Stream<String> tabStream = Arrays.stream(tableau);

        // A partir d'un fichier
        File file = new File("1.tmp");
        PrintWriter pw = new PrintWriter(file);
        pw.println("a1");
        pw.println("a2");
        pw.println("a3");
        pw.close();

        Stream<String> fileStream = Files.lines(Paths.get(file.getAbsolutePath()));

        // A partir d'une collection
        Collection<String> collection = Arrays.asList("a1","a2","a3");
        Stream<String> collectionStream =  collection.stream();

        testFilterAndCount();
    }

    private static void testFilterAndCount() {
        System.out.println(">>>>> test filter and count:");
        Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");

        //nombre d'occurrences de a1
        long count = collection.stream()
                //.filter("a1"::equals)
                .filter(element -> element.equals("a1"))
                .count();
        System.out.println("nombre = "+count);

        List<People> peoples = new ArrayList<>();
        peoples.add(new People("William", 16, Sexe.MAN));
        peoples.add(new People("John", 26, Sexe.MAN));
        peoples.add(new People("Helene", 42, Sexe.WOMAN));
        peoples.add(new People("Peter", 69, Sexe.MAN));

        //Liste et le nombre de people apte pour le service militaire: age antre 18 et 27 et se sexe MAN

        //Affichez le nombre de people pouvant travailler: age min 18 ans et 60 nas max pour les hommes et 55 max pour les femmes
    }
}

enum Sexe{
    MAN,
    WOMAN
}

class People{
    private String name;
    private int age;
    private Sexe sexe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public People(String name, int age, Sexe sexe) {
        this.name = name;
        this.age = age;
        this.sexe = sexe;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sexe=" + sexe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Objects.equals(name, people.name) && sexe == people.sexe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sexe);
    }
}
