package fr.dawan.javaintermediare.valueObject;

import java.util.Objects;

//@Embeddable -> Jpa/Hibernate (Spring Data)
public class Adresse {

    private int num;
    private String street;

    public int getNum() {
        return num;
    }

    public String getStreet() {
        return street;
    }

    //Tous les attributs sont nécessaires
    public Adresse(int num, String street) {
        this.num = num;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return num == adresse.num && Objects.equals(street, adresse.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, street);
    }
}
