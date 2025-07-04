package fr.dawan.javaintermediare.designspatterns;

import fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability.*;
import fr.dawan.javaintermediare.designspatterns.comportement.mediator2.ChatRoom;
import fr.dawan.javaintermediare.designspatterns.comportement.mediator2.ChatUser;
import fr.dawan.javaintermediare.designspatterns.comportement.mediator2.IChatRoomMediator;
import fr.dawan.javaintermediare.designspatterns.comportement.mediator2.Participant;
import fr.dawan.javaintermediare.designspatterns.comportement.memento.Editeur;
import fr.dawan.javaintermediare.designspatterns.comportement.memento.EditeurMemento;
import fr.dawan.javaintermediare.designspatterns.comportement.observer.*;
import fr.dawan.javaintermediare.designspatterns.comportement.state.Commande;
import fr.dawan.javaintermediare.designspatterns.comportement.strategy.*;
import fr.dawan.javaintermediare.designspatterns.comportement.templatemethod.FacebookNetwork;
import fr.dawan.javaintermediare.designspatterns.comportement.templatemethod.NetworkTemplateMethod;
import fr.dawan.javaintermediare.designspatterns.comportement.templatemethod.TwitterNetwork;
import fr.dawan.javaintermediare.designspatterns.comportement.visitor.*;
import fr.dawan.javaintermediare.designspatterns.comportement.visitor2.AuditSecurityVisitor;
import fr.dawan.javaintermediare.designspatterns.comportement.visitor2.Company;
import fr.dawan.javaintermediare.designspatterns.comportement.visitor2.ProfitabilityVisitor;
import fr.dawan.javaintermediare.designspatterns.comportement.visitor2.VisitorGeneric;
import fr.dawan.javaintermediare.designspatterns.creation.builder.Product;
import fr.dawan.javaintermediare.designspatterns.creation.builder.User;
import fr.dawan.javaintermediare.designspatterns.creation.factory.ComputerFactory;
import fr.dawan.javaintermediare.designspatterns.creation.factory.Laptop;
import fr.dawan.javaintermediare.designspatterns.creation.factory.Phone;
import fr.dawan.javaintermediare.designspatterns.creation.prototype.Question;
import fr.dawan.javaintermediare.designspatterns.creation.prototype.Reponse;
import fr.dawan.javaintermediare.designspatterns.creation.singleton.Pdg;
import fr.dawan.javaintermediare.designspatterns.structure.adapter.ChargeurAdapter;
import fr.dawan.javaintermediare.designspatterns.structure.adapter.ChargeurAdapterImpl;
import fr.dawan.javaintermediare.designspatterns.structure.adapter.Volt;
import fr.dawan.javaintermediare.designspatterns.structure.composite.DepartementComposite;
import fr.dawan.javaintermediare.designspatterns.structure.composite.Depatement;
import fr.dawan.javaintermediare.designspatterns.structure.composite.FinancialDepatement;
import fr.dawan.javaintermediare.designspatterns.structure.composite.SalesDepartement;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.bad.BasicCar;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.bad.Car;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.bad.SportCar;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.good.LuxuryCarDecorator;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.good.SportCarDecorator;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.good.CarBasic;
import fr.dawan.javaintermediare.designspatterns.structure.decorator.good.ICar;
import fr.dawan.javaintermediare.designspatterns.structure.facade.FacadeHelper;
import fr.dawan.javaintermediare.designspatterns.structure.facade.MySqlHelper;
import fr.dawan.javaintermediare.designspatterns.structure.facade.OracleHelper;
import fr.dawan.javaintermediare.designspatterns.structure.proxy.Internet;
import fr.dawan.javaintermediare.designspatterns.structure.proxy.ProxyInternet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
        chain of responsability, observer, state, visitor, iterator, strategy, template method, Mediator

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
        Permet de mettre en pace un mécanisme de souscription pour l'envoi de notifications
        à plusieurs objets au sujet d'évenements concernant les objets qu'ils observent.
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

        System.out.println("___________Memento");
        /*
        Comment sauvegarder et restaurer l'état précedent d'un objet, en mémoire
         */

        Editeur ed = new Editeur();
        EditeurMemento memento = new EditeurMemento();
        ed.setContent("a");
        ed.setContent("b");
        ed.setContent("c");

        //Sauvegarde
        memento.setState(ed.createMemento());


        ed.setContent("e");
        ed.setContent("f");
        ed.setContent("g");

        //restaurer l'état sauvegardé -> c

        System.out.println(ed.restore(memento));

        System.out.println("__________Visitor");
        /*
        Pour le mettre en place, il faut des objets qui partagent le mm traitement, mais qui diffère selon
        le type de l'objet.
        Ce pattern permet de séparer les traitements des objets
        Rôle du Visitor: visiter tous les objets qui partagent le mm traitement
        Rôle des objets: accepter la visite du Visitor

        Intérêt:
        open/close: code ouvert à l'extension, mais fermé à la modification
         */

        List<Forme> formes = new ArrayList<>();
        formes.add(new Cercle());
        formes.add(new Rectangle());

        Visitor xmlVisitor = new XmlExport();
        formes.forEach(f -> f.accepter(xmlVisitor));

        Visitor jsonVisitor = new JsonExport();
        formes.forEach(f -> f.accepter(jsonVisitor));

        Company company = new Company();
        VisitorGeneric v1 = new AuditSecurityVisitor();
        company.accept(v1);

        VisitorGeneric v2 = new ProfitabilityVisitor();
        company.accept(v2);

        System.out.println("_______state:");
        /*
        Pour le mettre en place: il faut avoir un objet dont le comportement varie en fonction de son état.
        Concerne un objet qui peut avoir plusieurs états possibles connus d'avance.
        Ex: Document -> brouillant - en correction - publication
        Ex2: Commande: passée - payée - livrée - reçue

        Intérêt:
        open/close: code ouvert à l'extension, mais fermé à la modif.

        Permet de changer le comportement de l'objet sans changer sa structure interne
        State, propose d'extraire tout le code lié aux différents états de l'objet et de le mettre dans des classes distinctes.
        Ce qui permet de prendre en compte de nouveaux états ou de modifier ceux existants.


         */

        Commande cmd = new Commande();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();

        System.out.println("_________Mediator");
        /*
        Pour le mettre en place, il faut avoir des objets avec des dependences et des interactions.

        Mediator permet de réduire la notion de dependence entre les différents objets.

        Mediator doit connaite tous les objets et toutes interactions possibles entre ces objets.

        En final, tous les objets vont dependre du Mediator

        Ex: tour de contrôle des pistes d'attérissages
        Ex: plateforme de chat
         */

        IChatRoomMediator mediator = new ChatRoom();
        Participant p1 = new ChatUser("1", "Jean", mediator);
        Participant p2 = new ChatUser("2", "Julien", mediator);

        mediator.addUser(p1);
        mediator.addUser(p2);

        p1.send("Hello", "2");
        p2.send("Bonjour", "1");

        System.out.println("__________Strategy:");
        /*
        Permet de définir une famille d'algorithmes, de les mettre dans des classe séparées.

        Intérêt:
        open/close: code ouvert à l'extension, mais fermé à la modification.

        Ex: Application de déplacements GPS - itinéraire selon le mode choisit(voiture, transports en communs, à pieds)
        Ex: moyens de paiement en ligne
         */

        ShoppingCart cart = new ShoppingCart();
        Item i1 = new Item("sdsq145", 156);
        Item i2 = new Item("fgtyu", 120);

        cart.addItem(i1);
        cart.addItem(i2);

        cart.pay(new CreditCardPayStrategy("","","",""));
        cart.pay(new PaypalPayStrategy("email", "password"));
        cart.pay(new VirementPayStrategy("1258qdsqdsqd"));

        System.out.println("_______ Template Method:");
        /*
        A mettre en place lorsque:
        des classes contiennent beaucoup de code similaire (méthodes). Bien le code soit complètement différent d'une classe à une autre
        la structure de base reste la mm (les étapes sont les mm).

        Ex: Envoi d'un message via un réseau social: Etapes: login - send message - logout

        Template Method permet de définir le squelette d'un algorithme dans la classe mère et laisse les classes filles
        redéfinir certaines étapes.

        Propose de découpe un algorithme en série étapes, de transformer chaque étape en méthode
        ensuite de les regrouper d'une seule méthode socle appelée Template Method

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NetworkTemplateMethod network = null;

        System.out.println("Input user name: ");
        String userName = br.readLine();

        System.out.println("Input password: ");
        String password = br.readLine();

        System.out.println("Input message: ");
        String message = br.readLine();

        System.out.println("""
                Choose social network:
                1- Facebook
                2- Twitter                
                """);

        int choix = Integer.parseInt(br.readLine());
        if(choix == 1){
            network = new FacebookNetwork(userName, password);
        }else if(choix == 2){
            network = new TwitterNetwork(userName,password);
        }
        /*
        Sans Template Method:
        login()
        sendMessage()
        logout()
         */

        //Appel de la Template Method
        network.post(message);

        System.out.println(">>>>>>>>>>>>>>>>>>>> Patterns de Structure:");
        /*
        Appelés aussi Patterns de Composition.
        Dans une conception basée sur les interactions: une application qui interagie avec des systèmes externes (API, BD....),
        les patterns de structure s'avèrent très utiles.

        Pour interagir avec les systèmes externes, le système cible passe forcément par les patterns de structure

         */

        System.out.println("______Proxy:");
        /*
        Permet de fournir un substitut d'un objet.
        Dans un code, un Proxy est une copie de l'objet original, les 2 partagent la mm structure
         */

        Internet internet = new ProxyInternet();
try {
    internet.connectTo("dawan.com");
    internet.connectTo("123.com");

} catch (Exception e) {
    System.out.println(e.getMessage());
}

        System.out.println("______Adapter:");

        /*
        Adatpter le contenu fournit par le système externe aux besoins de l'application en cours de dév.
         */
        ChargeurAdapter adapter = new ChargeurAdapterImpl();
        Volt vlt1 = adapter.get4Volts();
        System.out.println("Mobile 4 volts");

        Volt vlt2 = adapter.get10Volts();
        System.out.println("Tablette 10 volts");

        Volt vlt3 = adapter.get120Volts();
        System.out.println("PC 120 volts");

        System.out.println("______Bridge:");

        /*
        Permet de défir un pont entre l'application en cours de dév. et les différents systèmes externes
         */

        System.out.println("______Composite:");
        /*
        - Pouvoir manipuler des objets individuellement
        - Pouvoir manipuelr une composition d'objets

        Contrainte: Les objets à manipuler doivent partager la mm structure (les mm méthodes)
         */

        //Sans le Composite: manipulation des objets individuellement
        Depatement financialDep = new FinancialDepatement();
        Depatement salesDep = new SalesDepartement();

        //Avec le Composite: manipuler une composition d'objets (1 seul objet à manipuler dans le code)

        DepartementComposite composite = new DepartementComposite();
        composite.addDepartement(salesDep);
        composite.addDepartement(financialDep);

        composite.printDepartementName();

        System.out.println("_________Facade");
        /*
        propose un accès simplifié à un ensemble de classes complèxes.
        Ex: application qui appelle une BD distante (MySql, Oracle) et génère des rapports HTML et PDF.
        Facade propose en sortie des méthodes répondant aux besoins de l'application cible

         */

        //Code sans Facade:
        String tableName = "employes";
        Connection cnx = MySqlHelper.getMySqlConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHtmlReport(tableName, cnx);
        mySqlHelper.generateMySqlPdfReport(tableName, cnx);

        Connection cnx2 = OracleHelper.getOracleConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraceHtmlReport(tableName, cnx2);
        oracleHelper.generateOraceHtmlReport(tableName, cnx2);

        //Code avec Facade
        FacadeHelper.generateReport(FacadeHelper.DatabaseType.MYSQL, FacadeHelper.ReportType.HTML, tableName);
        FacadeHelper.generateReport(FacadeHelper.DatabaseType.ORACLE, FacadeHelper.ReportType.PDF, tableName);

        System.out.println("_________Decorator");
        /*
        Permet d'affecter des comportements à des objets de manière dynamique,
        dans des decorateurs (Wrapper - Classes) qui implèmentent ces comportements

        L'héritage est statique. Vous ne pouvez modifier le comportement au moment de l'exécution.
        Vous ne pouvez que remplacer la totalité de l'objet par un autre génère par une autre classe fille.

        Solution: remplacer l'héritage par une composition

        Intérêts:
        réduire le couplage entre les objets
        pouvoir affecter des comportements aux objets de manières

         */

        System.out.println(">>>> Sans Decorator:");
        Car car = new BasicCar();

        //Ajouter des options sportives
        car = new SportCar();

        car.assemble(); //1 seule méthode exécutée, celle de la classe SportCar - a cause de l'héritage qui est statique

        System.out.println(">>>> Avec Decorator");

        ICar myCar = new CarBasic();

        //Ajout d'options:
        myCar = new SportCarDecorator(myCar);
        myCar.assemble(); // 2 méthodes seront exécutées

        System.out.println(">>>>>>> options de luxe:");

        myCar = new LuxuryCarDecorator(myCar);

        myCar.assemble(); // 3 méthodes


    }
}
