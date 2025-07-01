package fr.dawan.javaintermediare.solid.dependecyinversion.good;

public class app {

    public static void main(String[] args) {

        //option1:
        ContactService service = new ContactService(new ContactRepository());
        service.computeContact(10);

        //option2:
        service.computeContact(10, new ContactRepository());

        service.computeContact(10, new ContactFichierRepository());

        //option3:
        ContactService myService = new ContactService();
        service.setContactRepository(new ContactRepository());
        service.setContactRepository(new ContactFichierRepository());


    }
}
