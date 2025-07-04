package fr.dawan.javaintermediare.genericite;

import java.io.Serializable;

public class Produit implements Serializable {

    private int id;
    private String description;
    private  double prix;
    //private transient double prix; -> transient: permet d'ignorer cet attribut lors de la sérialisation

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Produit(int id, String description, double prix) {
        this.id = id;
        this.description = description;
        this.prix = prix;
    }

    public Produit() {
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}
