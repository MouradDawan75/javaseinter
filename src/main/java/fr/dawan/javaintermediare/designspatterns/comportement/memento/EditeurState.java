package fr.dawan.javaintermediare.designspatterns.comportement.memento;

public class EditeurState {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditeurState(String content) {
        this.content = content;
    }
}
