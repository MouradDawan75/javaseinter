package fr.dawan.javaintermediare.apistream;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        testMap();
        testSkipAndLimit();
        testSorted();

        /*
        2 types de stream:
        - Sequentiel
        - Parallel: permet d'exécuter du code en parallel dans des Threads séparés.
        Le résultat final est une combinaison de chaque résultat individuel
        Pratique pour un appliquer le mm traitement à tous les éléments d'une collection
         */

        testStreamParallel();



        testReduce();
        testStreamParallelReduce();
    }

    private static void testStreamParallelReduce() {
        System.out.println(">>>>> Test Stream Parallel Reduce............");
        System.out.println(IntStream.rangeClosed(1,10).parallel().reduce(-10, Integer::sum));
        /*
        -10 sera appliqué pour chaque élément de la liste
        Résutlat final = somme de chaque résultat individuel
         */
        // -9,-8, -7,-6,
    }

    private static void testReduce() {

        System.out.println(">>>>>> Test Reduce............");

        List<Integer> entiers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int resultat = entiers.stream()
                .reduce(-10, Integer::sum);

        System.out.println("résultat = "+resultat);
    }

    private static void testStreamParallel() {
        System.out.println(">>>>> Stream Parallel:");
        List<Integer> entiers = Arrays.asList(1,2,3,4);

        entiers.parallelStream()
                //vérifier que élément de a liste est traité par un Thread à part
                .forEach(n -> System.out.println(n+" "+Thread.currentThread().getName()));
        /*
        2 syntaxes pour le StreamParallel:
          entiers.stream().parallel()
          entiers.parallelSream()
         */


    }

    private static void testSorted() {
        Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");

        System.out.println(">>>>> Test sorted:");
        collection.stream()
                .sorted() //tri ascendant par défaut
                .forEach(System.out::println);

        System.out.println(">>>> Tri descendant:");
        collection.stream()
                .sorted((s1, s2) -> -s1.compareTo(s2)).distinct().forEach(System.out::println);
    }

    private static void testSkipAndLimit() {

        Collection<String> collection = Arrays.asList("a1","a2","a3","a4","a5");

        System.out.println(">>>>>> Test skip and limit:");

        //pagination
        //afficher les 2 premiers éléménts
        collection.stream()
                .skip(0)
                .limit(2)
                .forEach(e -> System.out.println(e));

        //2 éléments suivants
        collection.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println);
    }

    private static void testMap() {
        System.out.println(">>>>>>> Test Map:");

        List<People> peoples = new ArrayList<>();
        peoples.add(new People("William", 16, Sexe.MAN));
        peoples.add(new People("John", 26, Sexe.MAN));
        peoples.add(new People("Helene", 42, Sexe.WOMAN));
        peoples.add(new People("Peter", 69, Sexe.MAN));

        List<PeopleDto> dtos =peoples.stream()
                .map(people -> new PeopleDto(people.getName(), people.getAge()) )
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);

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

        //Liste et le nombre de people apte pour le service militaire: age entre 18 et 27 et se sexe MAN
        System.out.println(">>>>>>>>< Service militaire:");
        peoples.stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27 && p.getSexe().equals(Sexe.MAN) )
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Affichez le nombre de people pouvant travailler: age min 18 ans et 60 ans max pour les hommes et 55 max pour les femmes
        System.out.println(">>>>>>> Personnes pouvant travailler:");
        long nb = peoples.stream()
                .filter(p -> p.getAge() >= 18)
                .filter( p ->( p.getSexe().equals(Sexe.WOMAN) && p.getAge() <= 55) || (p.getSexe().equals(Sexe.MAN) && p.getAge() <= 60))
                .count();

        System.out.println("People pouvant travaillé: "+count);

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

class PeopleDto{
    private String name;
    private int age;

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

    public PeopleDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PeopleDto() {
    }

    @Override
    public String toString() {
        return "PeopleDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
