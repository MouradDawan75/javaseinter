package fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability;

public class Teacher extends Staff{

    public Teacher(String name, Staff successor) {
        super(name, successor);
    }

    //Ne peut traiter que les plaintes de niveau 1
    @Override
    public void handleComplaint(ComplaintRequest request) {
        if(request.getComplaintType() == 1){
            System.out.println(request.getMessage()+" Req. traitée par le teacher......");
            request.setComplaintState(ComplaintState.CLOSED);
        }else{
            System.out.println(">>>> Requête transmise au succésseur (Responsable pedagogique)");
            getSuccessor().handleComplaint(request);
        }

    }
}
