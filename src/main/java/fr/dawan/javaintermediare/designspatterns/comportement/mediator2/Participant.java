package fr.dawan.javaintermediare.designspatterns.comportement.mediator2;

public abstract class Participant {

    private String id;
    private String name;
    private IChatRoomMediator mediator;

    public Participant(String id, String name, IChatRoomMediator mediator) {
        this.id = id;
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void send(String msg, String userId);
    public abstract void receive(String msg);

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IChatRoomMediator getMediator() {
        return mediator;
    }
}
