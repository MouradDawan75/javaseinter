package fr.dawan.javaintermediare.designspatterns.comportement.state;

public class CommandeValidee implements CommandeState{
    @Override
    public void next(Commande cmd) {
        cmd.setState(new CommandePayee());
    }

    @Override
    public void previous(Commande cmd) {
        System.out.println("Commande prise en compte. Attente du paiement......");
    }

    @Override
    public void printState() {
        System.out.println("Commande validée, pas encore livrée......");
    }
}
