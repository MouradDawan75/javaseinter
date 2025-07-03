package fr.dawan.javaintermediare.designspatterns.comportement.state;

public class CommandeLivree implements CommandeState{
    @Override
    public void next(Commande cmd) {
        cmd.setState(new CommandeRecue());
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandePayee());
    }

    @Override
    public void printState() {
        System.out.println("Attente de la confirmation de la livraison.........");
    }
}
