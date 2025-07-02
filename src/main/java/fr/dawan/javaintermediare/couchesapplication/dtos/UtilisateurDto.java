package fr.dawan.javaintermediare.couchesapplication.dtos;

/*
DTO: Data Transfert Object: appelé objet métier. Contient les données de la couche service
 */

public class UtilisateurDto {

    private int id;
    private String nom;
    private String email;
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UtilisateurDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
