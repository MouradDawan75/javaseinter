package fr.dawan.javaintermediare.designspatterns.comportement.observer;

import java.util.Scanner;

public class Customer implements Observer<CompteBancaire>{

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Customer(String nom) {
        this.nom = nom;
    }

    public Customer() {
    }

    @Override
    public void update(CompteBancaire cpt) {
        System.out.println("Votre solde est négatif, il est de: "+cpt.getSolde());
        System.out.println("Vous devez régulariser votre situation");
        System.out.println("Voulez vous effectuer un dépôt? (oui/non)");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.next();
        if(reponse.equalsIgnoreCase("oui")){
            System.out.println("Montant à déposer: ");
            double montant = sc.nextDouble();
            cpt.depot(montant);
            System.out.println("Nouveau solde: "+cpt.getSolde());
        }else{
            System.out.println("Attention, vous avez 48h pour régulariser votre situation....");
        }
    }
}
