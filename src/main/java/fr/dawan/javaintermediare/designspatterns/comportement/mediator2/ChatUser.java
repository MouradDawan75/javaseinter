package fr.dawan.javaintermediare.designspatterns.comportement.mediator2;

public class ChatUser extends Participant{


    public ChatUser(String id, String name, IChatRoomMediator mediator) {
        super(id, name, mediator);
    }

    @Override
    public void send(String msg, String userId) {

        System.out.println(getName()+" >>> Send message: "+msg);
        getMediator().sendMessage(msg, userId);

    }

    @Override
    public void receive(String msg) {
        System.out.println(getName()+" >>> Receive: "+msg);
    }
}
