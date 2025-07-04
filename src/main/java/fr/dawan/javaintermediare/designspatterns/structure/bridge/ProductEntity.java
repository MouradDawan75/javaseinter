package fr.dawan.javaintermediare.designspatterns.structure.bridge;

public class ProductEntity {

    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ProductEntity(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public ProductEntity() {
    }
}
