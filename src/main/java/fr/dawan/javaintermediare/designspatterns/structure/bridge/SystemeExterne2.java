package fr.dawan.javaintermediare.designspatterns.structure.bridge;


import java.util.ArrayList;
import java.util.List;

class Produit{
    private int id;
    private String description;

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

    public Produit(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Produit() {
    }
}

public class SystemeExterne2 {
    public List<Produit> getProducts(){
        List<Produit> lst = new ArrayList<>();
        lst.add(new Produit(15,"pr15"));
        lst.add(new Produit(20,"pr20"));

        return lst;
    }

}
