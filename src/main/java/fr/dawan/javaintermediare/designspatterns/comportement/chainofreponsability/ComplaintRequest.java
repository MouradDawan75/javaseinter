package fr.dawan.javaintermediare.designspatterns.comportement.chainofreponsability;

public class ComplaintRequest {

    private int studentNumero;
    private int complaintType; //1: prof - 2: responsable pedo - 3: directeur
    private String message;
    private ComplaintState complaintState;

    public int getStudentNumero() {
        return studentNumero;
    }

    public void setStudentNumero(int studentNumero) {
        this.studentNumero = studentNumero;
    }

    public int getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(int complaintType) {
        this.complaintType = complaintType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ComplaintState getComplaintState() {
        return complaintState;
    }

    public void setComplaintState(ComplaintState complaintState) {
        this.complaintState = complaintState;
    }

    public ComplaintRequest(int studentNumero, int complaintType, String message, ComplaintState complaintState) {
        this.studentNumero = studentNumero;
        this.complaintType = complaintType;
        this.message = message;
        this.complaintState = complaintState;
    }
}
