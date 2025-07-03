package fr.dawan.javaintermediare.designspatterns.comportement.strategy;

public class Item {

    private String qrCode;
    private double price;

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item(String qrCode, double price) {
        this.qrCode = qrCode;
        this.price = price;
    }
}
