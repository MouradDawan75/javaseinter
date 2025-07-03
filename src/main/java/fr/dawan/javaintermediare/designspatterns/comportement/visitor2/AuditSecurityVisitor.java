package fr.dawan.javaintermediare.designspatterns.comportement.visitor2;

public class AuditSecurityVisitor implements VisitorGeneric<Company, SecurityReport>{
    @Override
    public SecurityReport visit(Company obj) {
        /*
        Contrôle des mesures de sécurité et rédaction d'un rapport
         */
        return new SecurityReport();
    }
}
