package fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability;

public class Directeur extends Staff{

    public Directeur(String name, Staff successor) {
        super(name, successor);
    }

    //Traite les plaintes de niveau 3 et plus
    @Override
    public void handleComplaint(ComplaintRequest request) {
        System.out.println(request.getMessage()+" traitée par le Directeur");
        request.setComplaintState(ComplaintState.CLOSED);
    }
}
