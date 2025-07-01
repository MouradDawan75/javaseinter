package fr.dawan.javaintermediare.javafonctionnel;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Contact contact = new Contact("Jean", "0606060606");
        afficherContactBiConsumer.accept(contact, true);
        afficherContactBiConsumer.accept(contact, false);

    }


    static void afficherContact(Contact c){
        System.out.println(c);
    }

    static Consumer<Contact> afficherContactConsumer = c -> System.out.println(c);
    static BiConsumer<Contact,Boolean> afficherContactBiConsumer = (c, showPhoneNumber) ->
            System.out.println("Bonjour "+c.getContactName()+" merci pour votre enregistrement, tél:"+(showPhoneNumber? c.getContactPhoneNumber(): "*******"));
}



class Contact{
    private String contactName;
    private String contactPhoneNumber;

    public Contact(String contactName, String contactPhoneNumber) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
