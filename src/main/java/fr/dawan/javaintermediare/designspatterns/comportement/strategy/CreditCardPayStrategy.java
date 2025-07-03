package fr.dawan.javaintermediare.designspatterns.comportement.strategy;

public class CreditCardPayStrategy implements PaymentStrategy{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateExperacy;

    public CreditCardPayStrategy(String name, String cardNumber, String cvv, String dateExperacy) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateExperacy = dateExperacy;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount+" paid with credit/card");
    }
}
