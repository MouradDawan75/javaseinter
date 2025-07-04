package fr.dawan.javaintermediare.designspatterns.structure.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{

    //Un Proxy manipule l'objet original avec de le transmettre au système cible
    private Internet internet = new RealInternet();

    static List<String> bannedUrls;

    static {
        bannedUrls = new ArrayList<>();
        bannedUrls.add("abc.com");
        bannedUrls.add("123.com");
        bannedUrls.add("azerty.com");
    }

    @Override
    public void connectTo(String url) throws Exception {
        if(bannedUrls.contains(url)){
            throw new Exception("Access denied...........");
        }
        internet.connectTo(url);
    }
}
