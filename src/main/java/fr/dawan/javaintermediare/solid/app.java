package fr.dawan.javaintermediare.solid;

import fr.dawan.javaintermediare.solid.liskovsubstitution.bad.Bicycle;
import fr.dawan.javaintermediare.solid.liskovsubstitution.bad.Car;
import fr.dawan.javaintermediare.solid.liskovsubstitution.bad.TransportationDevice;

public class app {

    public static void main(String[] args) {
        /*
        Liskov Substitution: concerne l'héritage - le comportement des objets
        Les objets enfants doivent être substituables aux objets parents.
        Remplacer un objet parent par un objet enfant ne doit pas modifier le comportement de l'application

        Si A se comporte comme B, alors A hérite de B
         */

        TransportationDevice parent = new TransportationDevice();
        parent.startEngine();

        parent = new Car(); //car se comporte comme l'objet parent
        parent.startEngine();

        parent = new Bicycle();
        //parent.startEngine(); -> pas de moteur dans Bicycle
        //Bicycle ne se comporte pas comme l'objet parent -> Héritage non justifié

        /*
        Interface Segregation: découpage d'interfaces complèxes en petites interfaces ne gérant qu'un seul et unique besoin fonctionnel.
        Application du Singe Of Responsability dans les interfaces.
         */

    }
}
