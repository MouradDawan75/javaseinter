package fr.dawan.javaintermediare.solid.singleresponsability.good;

public class Employe {

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

    public Employe(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Employe() {
    }
}
