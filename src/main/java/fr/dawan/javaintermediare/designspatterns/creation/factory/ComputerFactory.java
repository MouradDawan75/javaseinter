package fr.dawan.javaintermediare.designspatterns.creation.factory;

public class ComputerFactory {
    /*
    Classe qui gère le processus de création d'objets enfant.
     */

    /*
    Méthode ne respectant pas le open/close
     */
    public Computer getComputer(String computer){
        if(computer.equalsIgnoreCase("phone")){
            return new Phone();
        }else if(computer.equalsIgnoreCase("laptop")){
            return new Laptop();
        }else if(computer.equalsIgnoreCase("smarttv")){
            return new SmartTv();
        }

        return null;
    }

    public Computer getComputer(Class<? extends Computer> clazz) throws Exception {
        /*
        Si une des classes filles ne possède pas de constructeur par defaut -> Exception
         */

        return clazz.getDeclaredConstructor().newInstance();
    }
}
