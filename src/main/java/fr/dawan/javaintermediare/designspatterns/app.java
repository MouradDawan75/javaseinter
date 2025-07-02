package fr.dawan.javaintermediare.designspatterns;

import fr.dawan.javaintermediare.designspatterns.creation.builder.Product;
import fr.dawan.javaintermediare.designspatterns.creation.builder.User;
import fr.dawan.javaintermediare.designspatterns.creation.singleton.Pdg;

public class app {

    static Pdg pdg3 = null, pdg4 = null;

    public static void main(String[] args) throws InterruptedException {
        /*
        Besoins de la conception objets: les bonnes pratiques
        - Encapsuler des données sans en empêcher l'accès -> get/set ou métodes métiers
        - Limiter les dépendences entre les objets: héritage-composition-association-relation
        - Concevoir des objets polyvalents, réutilisabes: polymorphisme
        - Code facile à maintenir: Single of responsability

        Designs Patterns: ce ne sont pas de bonnes pratiques. Ce sont des solutions classiques mises en place par
         la communauté objets, à des problèmes récurrents de la conception objet.

        Ce sont des solutions intéressantes, car elles respectent les bonnes pratiques

        Patterns de création:
        Singleton, builder, factory, prototype Abstract Factory, Object Pool

        Patterns de comportement:
        chain of responsability, observer, state, visitor, iterator, strategy, template method

        Patterns de structure:
        proxy,adapter,bridge,composite,facade,decorator

         */

        System.out.println(">>>>>>>>>>>>>>>>>>>> Patterns de création:");

        System.out.println("______Singleton");
        //>>>>>>> Singleton
        //problème: garantir l'existance d'une seule et unique instance d'une classe dans toute l'application

        Pdg pdg1 = Pdg.getInstance("pdg1");
        Pdg pdg2 = Pdg.getInstance("pdg2");

        System.out.println("pdg1: "+pdg1.getName());
        System.out.println("pdg2: "+pdg2.getName());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                pdg3 = Pdg.getInstance("pdg3");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                pdg4 = Pdg.getInstance("pdg4");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("pdg3 = "+pdg3.getName());
        System.out.println("pdg4 = "+pdg4.getName());

        System.out.println("______Builder");
        /*
        Builder: permet de construire des objets complèxes (avec bcp d'attributs) étape par étape
         */

        User u = User.builder("DUPONT", "Jean")
                .withAge(25)
                .build();

        User u1 = User.builder("n", "p")
                .withEmail("mail")
                .withPassword("pwd")
                .build();

        //Lombok implèmente le pattern builder
        Product p = Product.builder().id(55).name("pc dell").build();
        System.out.println(p);



    }
}
