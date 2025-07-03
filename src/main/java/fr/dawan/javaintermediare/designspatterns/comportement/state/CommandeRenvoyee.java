package fr.dawan.javaintermediare.designspatterns.comportement.state;

public class CommandeRenvoyee implements CommandeState{
    @Override
    public void next(Commande cmd) {
        System.out.println("Commande renvoyée par le client");
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandeRecue());
    }

    @Override
    public void printState() {
        System.out.println("Le renvoi de la commande est pris en compte........");
    }
}
