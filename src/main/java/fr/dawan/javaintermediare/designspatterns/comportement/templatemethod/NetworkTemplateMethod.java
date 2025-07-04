package fr.dawan.javaintermediare.designspatterns.comportement.templatemethod;

/**
 * Classe qui décrit le rôle du pattern Template Method
 */
public abstract class NetworkTemplateMethod {

    String userName;
    String password;

    public NetworkTemplateMethod(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    /*
    Etapes pour l'envoi d'un message
     */
    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logout();

    //Template Method: regrouper toutes les étape
    //La seule méthode à appeler dans le code

    public boolean post(String message){

        //appel de logIn
        if(logIn(userName, password)){

            //appel de sendMessage
            boolean result = sendData(message.getBytes());

            //appel de logout
            logout();

            return result;
        }

        return false;
    }
}
