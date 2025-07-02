package fr.dawan.javaintermediare.designspatterns.comportement.observer;

import java.util.ArrayList;
import java.util.List;

public class CompteBancaire implements Sujet<CompteBancaire>{

    private String numero;
    private double solde;

    List<Observer<CompteBancaire>> observers = new ArrayList<>();

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public CompteBancaire(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public CompteBancaire() {
    }

    @Override
    public void attach(Observer<CompteBancaire> o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer<CompteBancaire> o) {
    observers.remove(o);
    }

    @Override
    public void notify(CompteBancaire o) {
    observers.forEach(obs -> obs.update(o));
    }

    public void retrait(double montant){
        if(solde < montant){
            solde -= montant;
            notify(new CompteBancaire(numero, solde));
        }
    }

    public void depot(double montant){
        solde += montant;
    }
}
