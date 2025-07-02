package fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability;

/**
 * Classe qui décrit la chaine de responsabilité.
 * Chaque objet possède un succésseur
 * Chaque objet peut traiter la demande
 */
public  abstract class Staff {

    private String name;
    private Staff successor;

    public abstract void handleComplaint(ComplaintRequest request);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff getSuccessor() {
        return successor;
    }

    public void setSuccessor(Staff successor) {
        this.successor = successor;
    }

    public Staff(String name, Staff successor) {
        this.name = name;
        this.successor = successor;
    }
}
