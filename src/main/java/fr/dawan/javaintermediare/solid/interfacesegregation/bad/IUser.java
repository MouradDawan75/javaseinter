package fr.dawan.javaintermediare.solid.interfacesegregation.bad;

import java.time.LocalDate;

public interface IUser {

    void save(User u);
    void delete(User u);
    String contratType();
    LocalDate getDateEmbauche();
}
