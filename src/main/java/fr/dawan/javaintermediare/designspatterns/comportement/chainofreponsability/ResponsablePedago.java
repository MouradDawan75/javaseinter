package fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability;

public class ResponsablePedago extends Staff{


    public ResponsablePedago(String name, Staff successor) {
        super(name, successor);
    }

    //plaintes de niveau 2
    @Override
    public void handleComplaint(ComplaintRequest request) {
        if(request.getComplaintType() == 2){
            System.out.println(request.getMessage()+" Req. traitée par le Responsable Pedagogique......");
            request.setComplaintState(ComplaintState.CLOSED);
        }else{
            System.out.println(">>>> Requête transmise au succésseur (Directeur)");
            getSuccessor().handleComplaint(request);
        }
    }
}
