package fr.dawan.javaintermediare.solid.interfacesegregation.good;

public interface IUserRepository {
    void save(User u);
    void delete(User u);
    void update(User u);
}
