package fr.dawan.javaintermediare.designspatterns.comportement.visitor;

public class Cercle implements Forme{
    @Override
    public void accepter(Visitor v) {
        v.Visit(this);
    }

//    public void exportXml(){
//        //logic
//    }

    //si besoin d'export en Json -> ajout d'une nouvelle méthode
}
