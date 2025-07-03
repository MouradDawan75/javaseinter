package fr.dawan.javaintermediare.designspatterns.comportement.memento;

public class EditeurMemento {

    private EditeurState state;

    public EditeurState getState() {
        return state;
    }

    public void setState(EditeurState state) {
        this.state = state;
    }

    public EditeurMemento(EditeurState state) {
        this.state = state;
    }

    public EditeurMemento() {
    }
}
