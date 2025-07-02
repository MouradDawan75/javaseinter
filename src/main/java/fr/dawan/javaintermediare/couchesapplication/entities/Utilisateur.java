package fr.dawan.javaintermediare.couchesapplication.entities;

import fr.dawan.javaintermediare.couchesapplication.dtos.UtilisateurDto;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private int id;
    private String nom;
    private String email;
    private String password;
    private boolean admin;

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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Utilisateur(int id, String nom, String email, String password, boolean admin) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Utilisateur() {
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                '}';
    }

    public UtilisateurDto getDto() {
        UtilisateurDto dto = new UtilisateurDto();
                    dto.setId(this.getId());
            dto.setNom(this.getNom());
            dto.setEmail(this.getEmail());
            dto.setPassword(this.getPassword());
            return dto;
    }
}
