package fr.dawan.javaintermediare.designspatterns.comportement.strategy;

public class PaypalPayStrategy implements PaymentStrategy{

    private String email;
    private String password;

    public PaypalPayStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount+" paid using paypal.........");
    }
}
