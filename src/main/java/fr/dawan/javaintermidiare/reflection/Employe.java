package fr.dawan.javaintermidiare.reflection;

public class Employe extends Object{

    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Employe() {
        this.nom = "DUPONT";
        this.prenom = "Jean";
    }

    public void identite(){
        System.out.println(this.nom+" "+this.prenom);
    }
}
