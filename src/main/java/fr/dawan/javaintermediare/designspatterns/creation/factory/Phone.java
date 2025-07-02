package fr.dawan.javaintermediare.designspatterns.creation.factory;

public class Phone implements Computer{
    @Override
    public void compute() {
        System.out.println("phone...........");
    }
}
