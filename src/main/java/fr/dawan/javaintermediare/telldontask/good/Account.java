package fr.dawan.javaintermediare.telldontask.good;

public class Account {

    private int id;
    private double balances;

    public double getBalancess() {
        return balances;
    }

    public void setBalance(double balance) {
        this.balances = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void withdraw(double amount) throws Exception {
        if(balances < amount)
            throw new Exception("Error..........");

        balances -= amount;
    }
}
