package fr.dawan.javaintermediare.designspatterns.comportement.state;

public class CommandePayee implements CommandeState{
    @Override
    public void next(Commande cmd) {
        cmd.setState(new CommandeLivree());
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandeValidee());
    }

    @Override
    public void printState() {
        System.out.println("Commande payée en cours de livraison.....");
    }
}
