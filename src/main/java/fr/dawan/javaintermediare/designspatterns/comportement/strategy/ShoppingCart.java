package fr.dawan.javaintermediare.designspatterns.comportement.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item i){
        items.add(i);
    }

    public void removeItem(Item i){
        items.remove(i);
    }

    public double total(){
        double t = 0;
        for (Item i : items)
            t += i.getPrice();

        return t;
    }

    //Paiement:
    //Option1: définir une méthode pour chaque moyen de paiement
    //paiement par CB
    //paiement Paypal
    //open/close: si autre moyen de paiement a prendre en compte (chèque) -> ajout d'1 nouvelle méthode

    /*
    Option2: déleguer la gestion du paiement à une classe qui va définir une stratégie de paiement
     */

    public void pay(PaymentStrategy strategy){
        double amount = this.total();
        strategy.pay(amount);
    }
}
