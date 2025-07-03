package fr.dawan.javaintermediare.designspatterns.comportement.visitor2;

public class Company implements Element{

    private String name;
    private String mesureSecutite;
    private double profitabilite;

    public Company() {
        name= "Carrefour";
        mesureSecutite = "s1";
        profitabilite = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesureSecutite() {
        return mesureSecutite;
    }

    public void setMesureSecutite(String mesureSecutite) {
        this.mesureSecutite = mesureSecutite;
    }

    public double getProfitabilite() {
        return profitabilite;
    }

    public void setProfitabilite(double profitabilite) {
        this.profitabilite = profitabilite;
    }

    @Override
    public void accept(VisitorGeneric v) {
        v.visit(this);
    }
}
