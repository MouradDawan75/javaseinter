package fr.dawan.javaintermediare.designspatterns.comportement.visitor2;

public class ProfitabilityVisitor implements VisitorGeneric<Company, String>{
    @Override
    public String visit(Company obj) {
        if(obj.getProfitabilite() < 0.5){
            return "bad profitabilty...";
        }
        return "good result.........";
    }
}
