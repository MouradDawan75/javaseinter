package fr.dawan.javaintermediare.designspatterns.comportement.strategy;

public class VirementPayStrategy implements PaymentStrategy{

    private String accountNumber;

    public VirementPayStrategy(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount+" payé via un virement sur le compte: "+accountNumber);
    }
}
