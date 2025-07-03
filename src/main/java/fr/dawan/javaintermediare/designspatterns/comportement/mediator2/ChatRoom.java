package fr.dawan.javaintermediare.designspatterns.comportement.mediator2;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements IChatRoomMediator{

    private Map<String, Participant> userMap = new HashMap<>();

    @Override
    public void addUser(Participant p) {
        userMap.put(p.getId(), p);
    }

    @Override
    public void sendMessage(String msg, String userId) {
        Participant p = userMap.get(userId);
        p.receive(msg);
    }
}
