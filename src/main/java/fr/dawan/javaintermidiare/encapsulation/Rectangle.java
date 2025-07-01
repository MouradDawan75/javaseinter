package fr.dawan.javaintermidiare.encapsulation;

/*
Encapsulation: l'accès aux attributs d'une classe pas forcément par les getter/setter
Remplacer les getter/setter par des méthodes métiers
Une classe doit protéger aux maximum son contenu et ne doit fournir que des méthodes métier en sortie
 */


public class Rectangle {

    private double hauteur;
    private double largeur;

    private double getHauteur() {
        return hauteur;
    }

    private void setHauteur(double hauteur) throws Exception {
        if(hauteur < 0)
            throw new Exception("Hauteur doit être positive.....");
        this.hauteur = hauteur;
    }

    private double getLargeur() {
        return largeur;
    }

    private void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public Rectangle(double hauteur, double largeur) throws Exception {
        setHauteur(hauteur);
        this.largeur = largeur;
    }

    public void redim(double largeur, double hauteur) throws Exception {
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    public double surface()  {
        return hauteur * largeur;
    }
}
