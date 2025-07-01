package fr.dawan.javaintermediare.solid.liskovsubstitution.good;

public class TransportationDeviceWithoutEngine extends TransportationDevice{
    @Override
    public void startMoving() {
        //logic propre à chaque classe fille
    }
}
