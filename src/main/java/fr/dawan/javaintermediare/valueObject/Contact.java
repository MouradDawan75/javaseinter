package fr.dawan.javaintermediare.valueObject;

import java.util.Objects;

/*
Entity: possède une identité (id) - un cycle de vie (etat interne qui peut evolué) - peut avoir des relations avec d'autres entity
2 Entity sont égales si elles possèdent le mm id


Value Object: objet non mutable - ne change pas dans le temps - pas de setter (une sorte de constante)
2 VO sont sont egaux s'ils possèdent les mm attributs

Intrérêt:
Réduire le nombre d'objets à gérer dans le code.

Addresse, Points GSP, Money.......

 */

//@Entity
public class Contact {

    private int id;
    private String name;

    //@Embedded -> ajoute 2 colonnes dans la table Contact (num,street)
    private Adresse adresse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
