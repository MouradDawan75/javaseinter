package fr.dawan.javaintermediare.designspatterns.structure.bridge;

import java.util.ArrayList;
import java.util.List;

class Product{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }
}

public class SystemeExterne1 {

    public List<Product> getProducts(){
        List<Product> lst = new ArrayList<>();
        lst.add(new Product(1,"p1"));
        lst.add(new Product(2,"p2"));

        return lst;
    }
}
