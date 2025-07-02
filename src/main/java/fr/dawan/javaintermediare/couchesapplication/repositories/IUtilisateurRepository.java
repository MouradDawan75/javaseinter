package fr.dawan.javaintermediare.couchesapplication.repositories;

import fr.dawan.javaintermediare.couchesapplication.entities.Utilisateur;


import java.util.List;

public interface IUtilisateurRepository {
    List<Utilisateur> getAll();
    void save(Utilisateur u );
    void delete(Utilisateur u);
}
