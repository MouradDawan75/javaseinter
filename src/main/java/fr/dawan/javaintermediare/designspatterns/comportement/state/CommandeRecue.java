package fr.dawan.javaintermediare.designspatterns.comportement.state;

public class CommandeRecue implements CommandeState{
    @Override
    public void next(Commande cmd) {
        System.out.println("Commande reçue par le client....");
    }

    @Override
    public void previous(Commande cmd) {
        cmd.setState(new CommandeLivree());
    }

    @Override
    public void printState() {
        System.out.println("Confirmation de la réception de la commande......");
    }
}
