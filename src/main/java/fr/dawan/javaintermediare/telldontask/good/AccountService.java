package fr.dawan.javaintermediare.telldontask.good;



public class AccountService {

    private IAccountRepository repo;

    public AccountService(IAccountRepository repo) {
        this.repo = repo;
    }

    public void withdraw(int id, double amount) throws Exception {
        Account a = repo.getById(id);
//        if(a.getBalance() < amount){
//            throw new Exception("Error: not enough money!");
//        }
//
//        a.setBalance(a.getBalance() - amount);

        a.withdraw(amount);
        repo.save(a);
    }
}

/*
Tell don't ask: Dites à vos objets ce qu'ils doivent faire, ne leur posez pas de questions sur leur état. (Pas d'appels aux get/set)
 */
