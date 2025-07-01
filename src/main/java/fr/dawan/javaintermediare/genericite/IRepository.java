package fr.dawan.javaintermediare.genericite;

public interface IRepository<T> {

    void insert(T obj);
    void delete(T obj);
    void update(T obj);
}
