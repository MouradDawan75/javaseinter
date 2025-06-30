package fr.dawan.javaintermidiare.javafonctionnel;

@FunctionalInterface
public interface ICalcul {

    int somme(int x, int y);
    //int soustraction(int x, int y);

    default void test() {};
    static void test2(){};
}
