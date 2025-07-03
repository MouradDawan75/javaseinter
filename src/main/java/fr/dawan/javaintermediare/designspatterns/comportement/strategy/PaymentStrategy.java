package fr.dawan.javaintermediare.designspatterns.comportement.strategy;

/**
 * Interface qui décrit le rôle du pattern Strategy.
 * Définir une stratégie de paiement
 */
public interface PaymentStrategy {

    void pay(double amount);
}
