package fr.dawan.javaintermediare.couchesapplication.repositories;

import fr.dawan.javaintermediare.couchesapplication.entities.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurRepositoryImpl implements IUtilisateurRepository{

    private List<Utilisateur> users = new ArrayList<>();

    public UtilisateurRepositoryImpl() {
        users.add(new Utilisateur(1,"admin","admin@dawan.fr","admin",true));
        users.add(new Utilisateur(2,"user","user@dawan.fr","user",false));
    }

    @Override
    public List<Utilisateur> getAll() {
        return users;
    }

    @Override
    public void save(Utilisateur u) {
        users.add(u);
    }

    @Override
    public void delete(Utilisateur u) {
        users.remove(u);
    }
}
