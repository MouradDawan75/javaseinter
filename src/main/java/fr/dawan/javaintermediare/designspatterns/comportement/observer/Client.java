package fr.dawan.javaintermediare.designspatterns.comportement.observer;

public class Client implements Observer<Double>{

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client(String nom) {
        this.nom = nom;
    }

    public Client() {
    }

    @Override
    public void update(Double o) {
        System.out.println(nom+ " Nouveau prix: "+o);
        System.out.println("Produit acheté.........");
    }
}
