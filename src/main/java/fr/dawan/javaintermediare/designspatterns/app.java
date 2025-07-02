package fr.dawan.javaintermediare.designspatterns;

import fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability.*;
import fr.dawan.javaintermediare.designspatterns.comportement.observer.*;
import fr.dawan.javaintermediare.designspatterns.creation.builder.Product;
import fr.dawan.javaintermediare.designspatterns.creation.builder.User;
import fr.dawan.javaintermediare.designspatterns.creation.factory.ComputerFactory;
import fr.dawan.javaintermediare.designspatterns.creation.factory.Laptop;
import fr.dawan.javaintermediare.designspatterns.creation.factory.Phone;
import fr.dawan.javaintermediare.designspatterns.creation.prototype.Question;
import fr.dawan.javaintermediare.designspatterns.creation.prototype.Reponse;
import fr.dawan.javaintermediare.designspatterns.creation.singleton.Pdg;

public class app {

    static Pdg pdg3 = null, pdg4 = null;

    public static void main(String[] args) throws Exception {
        /*
        Besoins de la conception objets: les bonnes pratiques
        - Encapsuler des données sans en empêcher l'accès -> get/set ou méthodes métiers
        - Limiter les dépendences entre les objets: héritage-composition-association-relation
        - Concevoir des objets polyvalents, réutilisables: polymorphisme
        - Code facile à maintenir: Single of responsability

        Designs Patterns: ce ne sont pas de bonnes pratiques. Ce sont des solutions classiques mises en place par
         la communauté objets, à des problèmes récurrents de la conception objet.

        Ce sont des solutions intéressantes, car elles respectent les bonnes pratiques

        Patterns de création:
        Singleton, builder, factory, prototype, Abstract Factory, Object Pool

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

        System.out.println("_________Factory:");
        /*
        A utiliser avec des objets liés  (classe mère + classes filles)
        Inconvénient:
        Sa complexité de mise en place.
        Avant de l'implémenter, se poser la question de sa complexité.
         */
        ComputerFactory factory = new ComputerFactory();
        Laptop laptop = (Laptop) factory.getComputer(Laptop.class);

        Phone phone = (Phone) factory.getComputer(Phone.class);

        System.out.println("_________Abstract Factory:");
        /*
        Une Factory de Factories: très complèxe
        Object Pool: le moins connu des patterns de création et souvent implementé par des framework
         */

        System.out.println("____________Prototype:");
        /*
        Création de copies d'objets à partir d'objets existants.
        Comment avoir des copies de types complèxes sans rendre le code dépendant.
        Faire une copie de A sans faire: b.setTaille() = a.getTaille()
         */

        //Types simples: la question ne pose pas
        int x = 5;
        int y = x; // y est une copie de x

        //Types complèxe:
        int[] tab = {10,20};
        int[] tab2 = tab; //tab2 n'est pas une copie de tab

        tab[0] = 99;
        System.out.println(tab2[0]);

        System.out.println(">>>> Copie d'une Reponse:");

        Reponse r1 = new Reponse("rep1", true);

        Reponse r2 = (Reponse) r1.clone();

        //copie sans faire appels aux get/set
//        r2.setText(r1.getText());
//        r2.setCorrect(r1.isCorrect());

        r1.setText("new text");
        r1.setCorrect(false);

        System.out.println(r2.getText()); //rep1
        System.out.println(r2.isCorrect()); //true

        System.out.println(">>>>>>> Copie d'une Question:");

        Question qst1 = new Question("Comment cloner un objet?");
        qst1.getReponses().add(new Reponse("implémenter l'interface cloneable", true));
        qst1.getReponses().add(new Reponse("implémenter l'interface copie", false));

        Question qst2 = (Question) qst1.clone();

        qst1.setTexte("nouvelle question");

        System.out.println(qst2.getTexte()); //Attribut texte non modifié

        qst1.getReponses().get(0).setText("nouvelle réponse.........");

        System.out.println(qst2.getReponses().get(0).getText()); // rep1 modifiée aussi pour qst2 -> ce n'est pas une copie


        System.out.println(">>>>>>>>>>>>>>>>>>>> Patterns de comportement:");

        System.out.println("____Chain of Responsability:");
        /*
        Pour le mettre en place:
        - il faut avoir une hierarchie de d'objets avec un traitement que tous les objets peuvent exécuter.
        - Chaque objet dans cette hierarchie possède un succésseur (objet supérieur) et peut soit traiter la demande ou la transmettre
        au succésseur.

        Ce pattern permet de faire ciculer une demande dans une chaine d'objets qui peuvent soit la traiter
          soit la transmettre au niveau supérieur.
                 */

        Teacher t = new Teacher("Teacher", new ResponsablePedago("ResPedago", new Directeur("directeur", null)));

        t.handleComplaint(new ComplaintRequest(125,1,"Req1", ComplaintState.OPENED));
        t.handleComplaint(new ComplaintRequest(356, 2, "Req2", ComplaintState.OPENED));
        t.handleComplaint(new ComplaintRequest(456,3,"Req3", ComplaintState.OPENED));

        System.out.println("____Observer:");
        /*
        Permet de mettre en pace un mécanisme de souscription pour envoyer des notifiactions
        à plusieurs objets au sujet d'évenement concernant les objets qu'ils observent.
         */

        Produit prod = new Produit("PC Dell", 2000);
        Observer<Double> obs1 = new Client("Mark");
        Observer<Double> obs2 = new Client("Julie");

        prod.attach(obs1);
        prod.attach(obs2);

        prod.setPrix(1599); //cette modif. déclenche l'envoi de 2 notifs

        CompteBancaire cpt = new CompteBancaire("145df", 1000);
        Customer cust = new Customer("Jean");
        cpt.attach(cust);

        cpt.retrait(4500); // ce retrait déclenche l'envoi d'une notif.



    }
}
