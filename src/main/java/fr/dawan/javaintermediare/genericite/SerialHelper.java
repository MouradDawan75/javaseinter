package fr.dawan.javaintermediare.genericite;

import com.google.gson.Gson;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Obligation: une ressource (fichier, BD) doit être libérée à la fin de son utilisation
Stream (flux): est une sorte de canal intermédiaire entre une source et une destination
Java propose 2 types de flux:
Fluxs binaires: lecture/écriture caractères: FileInputStream -FileOutputStream (BufferedInputStream, BufferedOutputStream)
Fluxs caractères: lecture/écriture ligne/ligne: FileReader- FileWriter (BufferedReader, BufferedWriter)

Bonne pratique: prévoir un buffer pour les opérations de lecture/écriture

 */

public class SerialHelper {

    //méthode de sérialisation binaire
    public static void exportBin(String path, List<Produit> lst) {
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

//        //Option2: faire une remontée d'exception
//        File f = new File(path);
//        if(f.exists()){
//
//        }else{
//            throw new Exception("Chemin invalide......");
//        }
    }

    public static List<Produit> importBin(String path){
            List<Produit> lst = new ArrayList<>();

            try {
                FileInputStream fis = new FileInputStream(path);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                lst = (List<Produit>) ois.readObject();
                ois.close();

                return lst;
            } catch (Exception e) {
                //remplir un fichier de logs
                e.printStackTrace();
                return null;
            }
        }

        public static void exportXml(String path, List<Produit> lst){
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

        public static List<Produit> importXml(String path){
        List<Produit> lst = new ArrayList<>();
        try{

            FileInputStream fis = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);

            XMLDecoder xml = new XMLDecoder(bis);
            lst = (List<Produit>) xml.readObject();
            xml.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        }

        public static void exportJson(String path, List<Produit> lst){
        try {

            Gson gson =new Gson();
            FileWriter fw = new FileWriter(path);
            gson.toJson(lst,fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public static List<Produit> importJson(String path){

        try {
            Gson gson = new Gson();
            FileReader fr = new FileReader(path);
            Produit[] tab = gson.fromJson(fr, Produit[].class);
            fr.close();
            return Arrays.asList(tab);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        }

        public static void exportCsv(String path, List<Produit> lst){
        try {

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
            for(Produit p : lst){
                String ligne = p.getId()+","+p.getDescription()+","+p.getPrix()+"\n";
                bos.write(ligne.getBytes());
            }

            bos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }

        public static List<Produit> importCsv(String path){
        List<Produit> lst = new ArrayList<>();
        try{

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String ligne = br.readLine();

            while(ligne != null){

                //découoer la ligne en cours
                String[] tab =  ligne.split(",");
                Produit p = new Produit(Integer.parseInt(tab[0]), tab[1], Double.parseDouble(tab[2]));
                lst.add(p);
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

