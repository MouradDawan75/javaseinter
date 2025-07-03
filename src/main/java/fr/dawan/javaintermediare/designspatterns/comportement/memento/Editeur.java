package fr.dawan.javaintermediare.designspatterns.comportement.memento;

public class Editeur {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditeurState createMemento() {
        return new EditeurState(content);
    }

    public String restore(EditeurMemento memento) {
        return memento.getState().getContent();
    }
}
