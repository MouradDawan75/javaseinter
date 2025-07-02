package fr.dawan.javaintermediare.designspatterns.creation.prototype;

public class Reponse implements Cloneable{

    private String text;
    private boolean correct;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Reponse(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public Reponse() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
