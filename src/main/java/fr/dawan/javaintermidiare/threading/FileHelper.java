package fr.dawan.javaintermidiare.threading;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileHelper {

    public static void copieFichier(String src, String cible) throws Exception{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(cible);

        int tmp = fis.read();
        while(tmp != -1){
            fos.write(tmp);
            tmp = fis.read();
        }

        fis.close();
        fos.close();
    }
}
