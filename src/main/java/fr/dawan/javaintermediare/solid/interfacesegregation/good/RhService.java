package fr.dawan.javaintermediare.solid.interfacesegregation.good;

import java.time.LocalDate;

public class RhService implements IRh{
    @Override
    public String contratType() {
        return "";
    }

    @Override
    public LocalDate getDateEmbauche() {
        return null;
    }
}
