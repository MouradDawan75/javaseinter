package fr.dawan.javaintermediare.couchesapplication.helpers;


import org.modelmapper.ModelMapper;

class Employe{
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

class EmployeDto{
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "EmployeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

public class ModelMapperDemo {
    public static void main(String[] args) {

        Employe e = new Employe();
        e.setNom("DUPONT");
        e.setPrenom("Jean");

        ModelMapper mapper = new ModelMapper();
        EmployeDto dto = mapper.map(e, EmployeDto.class);

        System.out.println(">>>>> Mapping auto:");
        System.out.println(dto);

        System.out.println(">>>> Mapping perso:");
        mapper.typeMap(Employe.class, EmployeDto.class)
                .addMappings(m -> {
                    m.map(src -> src.getNom(), EmployeDto::setFirstName);
                    m.map(src -> src.getPrenom(), EmployeDto::setLastName);
                });

        EmployeDto dto2 =  mapper.map(e, EmployeDto.class);

        System.out.println(dto2);

    }
}
