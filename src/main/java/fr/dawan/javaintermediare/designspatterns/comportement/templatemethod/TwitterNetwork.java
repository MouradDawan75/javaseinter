package fr.dawan.javaintermediare.designspatterns.comportement.templatemethod;

public class TwitterNetwork extends NetworkTemplateMethod{

    public TwitterNetwork(String username, String password) {
        super(username, password);
    }

    @Override
    boolean logIn(String userName, String password) {
        System.out.println("Check user parameters");
        System.out.println("Name: "+this.userName);
        System.out.println("Password: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        siumlerLatence();
        System.out.println("Login success on Twitter.....");
        return true;
    }

    private void siumlerLatence(){
        try {
            int i = 0;
            System.out.println();
            while (i < 10){
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    boolean sendData(byte[] data) {
        boolean messageSend = true;
        if(messageSend){
            System.out.println("Message: "+new String(data)+" was posted on Twitter......");
            return true;
        }

        return false;
    }

    @Override
    void logout() {
        System.out.println("User: "+userName+" was logged out from Twitter......");
    }
}
