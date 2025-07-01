package fr.dawan.javaintermediare.solid.dependecyinversion.bad;

public class ContactService {

    public Object computeContact(int id){
        ContactRepository repo = new ContactRepository();
        Contact c = repo.getById(id);

        //appliquer un traitement au contact

        return null;
    }
}
/*
Code sans dépendence
Méthode complètement dépendante de ContactRepository
 */
