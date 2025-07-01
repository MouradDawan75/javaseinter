package fr.dawan.javaintermediare.solid.dependecyinversion.good;

public class ContactService {

    //Invesrion de dépendence: le repo implèmente les besoins du service
    private IContactRepository contactRepository;

    //Option1: injection via le constructeur
    /*
    Avantage: Un objet ContactService crée dans un état stable
    Inconvénient: impossible de changer de dépendence
    Solution recommandée en pratique
     */


    public ContactService(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Object computeContact(int id){
        Contact c = contactRepository.getById(id);

        return null;
    }

    //Option2: injection via les params de la méthode
    /*
    Avantage: possibilité de changer de dépendence
    Inconvénient: dépendence à fournir à chaque appel de la méthode
     */

    public Object computeContact(int id, IContactRepository repo) {
        Contact c = repo.getById(id);

        return null;
    }

    //Option3: injection via le setter
    /*
    Avantage: possibilité de changer de dépendence
    Inconvénient - contrainte: il faut s'assurer que la dépendence à bien été injectée via le setter
    Déconseillée en pratique
     */


    public ContactService() {

    }

    public void setContactRepository(IContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
