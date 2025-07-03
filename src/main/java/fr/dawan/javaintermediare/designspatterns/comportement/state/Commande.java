package fr.dawan.javaintermediare.designspatterns.comportement.state;

public class Commande{

    /*
    Un objet dont le comportement varie selon son état
    Etats d'une commande:
    validée
    payée
    livrée
    reçue
    renvoyée
     */

    //Solution1:
    /*
    if(etat == validée)
        comportement
      else if(etat == payée)
          comportement
          ......................

          Si un nouvel état doit être pris en compte, on doit apporter des modifications au code initial
          modification: prise en compte du nouvel état -> renvoyée
     */

    //Gestion de l'état initial de l'objet
    private CommandeState state = new CommandeValidee();

    public CommandeState getState() {
        return state;
    }

    public void setState(CommandeState state) {
        this.state = state;
    }


    public void next() {
        state.next(this);
    }


    public void previous() {
        state.previous(this);
    }


    public void printState() {
    state.printState();
    }
}
