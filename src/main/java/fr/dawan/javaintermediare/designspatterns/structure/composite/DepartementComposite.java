package fr.dawan.javaintermediare.designspatterns.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class DepartementComposite implements Depatement{

    //une composition de Departements
    private List<Depatement> departements = new ArrayList<>();

    public void addDepartement(Depatement dep){
        departements.add(dep);
    }

    public void removeDepartement(Depatement dep){
        departements.remove(dep);
    }


    @Override
    public void printDepartementName() {
        departements.forEach(d -> d.printDepartementName());
    }
}
