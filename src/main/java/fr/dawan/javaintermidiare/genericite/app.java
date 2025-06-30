package fr.dawan.javaintermidiare.genericite;

import java.util.ArrayList;
import java.util.List;

public class app {

    public static void main(String[] args){
        /*
        Généricité: permet de créer méthodes, des classes ou interfaces identiques sur le plan algorithmique
        mais différent sur la base des types de données
        Intérêts:
        - réutilisation du code
        - moins de CAST: gain de temps et des ressources à l'exécution.
        - monis de risques liés a la conversion de types à 'exécution

                 */

        Calcul<Integer> calcul1 = new Calcul<Integer>();
        calcul1.a = 10;
        calcul1.b = 15;
        calcul1.swap();

        Calcul<String> calcul2 = new Calcul<>();
        calcul2.a = "chaineA";
        calcul2.b = "chaineB";
        calcul2.swap();

        String contenuA = calcul2.a;

        CalculObjet obj = new CalculObjet();
        obj.a = 10;
        obj.b = "test2";

        int i = (int) obj.a; // risque d'exception

        /*
        Sérialisation: mécanisme permettant de sauvergarder l'état  d'un objet dans un support de persistence: fichiers;
        , BD......
        3 types de sérialisations:
        Binaire: ObjectOutputStream - ObjectInputStream
        xml: XmlEncoder - XmlDecoder
        json: pas de classe fournit par l'api standard (Java SE)
        Solution: utiliser des librairies externes: Gson, Jackson-databind (utilisée par Spring Boot)
         */

        List<Produit> prods = new ArrayList<>();
        prods.add(new Produit(1,"PC Dell", 1999));
        prods.add(new Produit(2,"Ecran HP", 79));

        System.out.println(">>>>>>>>> Sérialisation binaire:");

        SerialHelper.exportBin("produits.bin", prods);

        for(Produit p : SerialHelper.importBin("produits.bin")){
            System.out.println(p);
        }

        System.out.println(">>>> Sérialisation xml:");
        SerialHelper.exportXml("produits.xml", prods);

        for(Produit pr : SerialHelper.importXml("produits.xml")){
            System.out.println(pr);
        }

        System.out.println(">>>>>>>>>> Sérialisation Json:");
        SerialHelper.exportJson("produits.json", prods);

        for(Produit prod : SerialHelper.importJson("produits.json")){
            System.out.println(prod);
        }

        System.out.println(">>>>>>>>> Sérialisation CSV");
        SerialHelper.exportCsv("produits.csv", prods);

    }
}
