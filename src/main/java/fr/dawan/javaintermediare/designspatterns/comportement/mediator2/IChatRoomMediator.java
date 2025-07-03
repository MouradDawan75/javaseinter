package fr.dawan.javaintermediare.designspatterns.comportement.mediator2;

/**
 * Interface qui décrit le rôle du pattern Mediator
 * Connaitre tous les objets
 * Gérer les interactions entre les différents objets
 */
public interface IChatRoomMediator {

    void addUser(Participant p);
    void sendMessage(String msg, String userId);
}
