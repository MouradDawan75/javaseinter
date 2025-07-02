package fr.dawan.javaintermediare.designspatterns.comportement.observer;

import java.util.ArrayList;
import java.util.List;

public class Produit implements Sujet<Double>{

    private String description;
    private double prix;
    private List<Observer<Double>> observers = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
        notify(prix);
    }

    public Produit(String description, double prix) {
        this.description = description;
        this.prix = prix;
    }

    public Produit() {
    }

    @Override
    public void attach(Observer<Double> o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer<Double> o) {
        observers.remove(o);
    }

    @Override
    public void notify(Double o) {
        observers.forEach(obs -> obs.update(o));
    }
}
