package fr.dawan.javaintermediare.telldontask.good;

public interface IAccountRepository {

    Account getById(int id);
    void save(Account a);
}
