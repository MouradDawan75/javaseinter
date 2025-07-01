package fr.dawan.javaintermediare.polymorphisme;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        /*
        Polymorphisme: c'est le fait qu'un objet puisse prendre plusieurs formes. C'est une conséquence de l'héritage
        c'est le fait que l'objet puisse prendre la forme de tous les objets enfants.
         */

        IPliable i = new Table();
        IPliable i2 = new Chaise();

        //Collection polymorphique
        List<IPliable> lst = new ArrayList<>();
        lst.add(new Table());
        lst.add(new Chaise());
        lst.add(new Lit());

        acheter(new Chaise());
        acheter(new Table());
        acheter(new Lit());

        List<A> objetA = new ArrayList<>();
        List<B> objetB = new ArrayList<>();
        List<C> objetC = new ArrayList<>();

        List<ITest> myLst = new ArrayList<>();
        myLst.add(new A());
        myLst.add(new B());
        myLst.add(new C());
        myLst.add(new D());

        methodPolymorphique(new A());
        methodPolymorphique(new B());
        methodPolymorphique(new C());
        methodPolymorphique(new D());
    }

    //Polymorphisme par sous typage
    public static void acheter(IPliable i){
        i.plier();
        i.deplier();
    }

    //Polymorphisme ad-hoc: déconseillé en pratique: nécessite un contrôle + un CAST
    public static void acheter2(Object o){
        if(o instanceof IPliable){
            IPliable i = (IPliable) o;
            i.deplier();
            i.plier();
        }
    }

    //Polymorphisme par paramètre générique avec une contrainte sur e type générique
    public static <T extends IPliable> void acheter3(T t){
        t.plier();
        t.deplier();
    }

    public static void methodA(A a){

    }

    public static void methodB(B b){

    }
    public static void methodC(C c){

    }

    public static void methodPolymorphique(ITest i){

    }
}
