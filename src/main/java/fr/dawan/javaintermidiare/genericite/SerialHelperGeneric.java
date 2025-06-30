package fr.dawan.javaintermidiare.genericite;

import com.google.gson.Gson;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerialHelperGeneric {

    //méthode de sérialisation binaire
    public static <T extends Serializable> void exportBinGeneric(String path, List<T> lst) {
        // Option1: la méthode gère sa propre exception
        try {

            FileOutputStream fos = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 16384);
            ObjectOutputStream oos = new ObjectOutputStream(bos); //nécessaire car des objets à insérer dans un fichier
            oos.writeObject(lst);
            oos.close();

        } catch (Exception e) {
            //remplir un fichier de logs
            e.printStackTrace();
        }

    }

    public static <T extends Serializable> List<T> importBinGeneric(String path){
        List<T> lst = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            lst = (List<T>) ois.readObject();
            ois.close();

            return lst;
        } catch (Exception e) {
            //remplir un fichier de logs
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void exportXmlGeneric(String path, List<T> lst){
        try {

            FileOutputStream fis = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(fis);

            XMLEncoder xml = new XMLEncoder(bos);
            xml.writeObject(lst);
            xml.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <T> List<T> importXmlGeneric(String path){
        List<T> lst = new ArrayList<>();
        try{

            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);

            XMLDecoder xml = new XMLDecoder(bis);
            lst = (List<T>) xml.readObject();
            xml.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> void exportJsonGeneric(String path, List<T> lst){
        try {

            Gson gson =new Gson();
            FileWriter fw = new FileWriter(path);
            gson.toJson(lst,fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> importJsonGeneric(String path, Class<T> clazz){

        ArrayList<T> lst = new ArrayList<>();
        try {
            Gson gson = new Gson();
            FileReader fr = new FileReader(path);


            ArrayList resutat = gson.fromJson(fr, lst.getClass());

            for(Object o : resutat){
                lst.add(gson.fromJson(gson.toJson(o), clazz));
            }

            fr.close();
            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void exportCsvGeneric(String path, List<T> lst){
        try {

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
            for(T obj : lst){
                //String ligne = p.getId()+","+p.getDescription()+","+p.getPrix()+"\n";
                //bos.write(ligne.getBytes());

                Class<?> classObj = obj.getClass();
                Field[] fields = classObj.getDeclaredFields();

                StringBuilder sb = new StringBuilder();

                for(Field f : fields){
                    f.setAccessible(true); //les attributs par définition sont en private
                    sb.append(f.get(obj).toString()).append(",");
                }
                //1,PC Dell,1999,
                //Suppression de la dernière virgule
                String ligne = sb.substring(0, sb.length() - 1) +"\n";

                bos.write(ligne.getBytes());
            }

            bos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> importCsvGeneric(String path, Class<T> clazz){
        List<T> lst = new ArrayList<>();
        try{

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String ligne = br.readLine();

            while(ligne != null){

                //découoer la ligne en cours
                String[] tab =  ligne.split(","); //["1", "PC Description", "1999"]

                T obj = clazz.getDeclaredConstructor().newInstance();

                Field[] fields = clazz.getDeclaredFields();
                int i = 0;
                for(Field f : fields){
                    f.setAccessible(true);
                    Class<?> type = f.getType();


                    if(type.equals(int.class)){
                      f.set(obj, Integer.parseInt(tab[i]));
                    }else if(type.equals(String.class)){
                        f.set(obj, tab[i]);
                    }else if(type.equals(double.class)){
                        f.set(obj, Double.parseDouble(tab[i]));
                    }else if(type.equals(Boolean.class)){
                        f.set(obj, Boolean.parseBoolean(tab[i]));
                    }

                    i++;
                }

                lst.add(obj);
                ligne= br.readLine();
            }

            br.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

}

