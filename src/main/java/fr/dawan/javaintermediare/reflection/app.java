package fr.dawan.javaintermediare.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class app {
    public static void main(String[] args) throws Exception {
        /*
        Reflection (introspection): mécanisme qui permet de découvrir des types et d'invoquer leur membres à
        l'exécution de manière dynamique
         */

        Class<Employe> employeClass = Employe.class;

        System.out.println(">>>>>>>>>> Méthodes de la classe Employe:");

        Method[] methodes =  employeClass.getMethods();
        for(Method m : methodes){
            System.out.println(m.getName());
        }

        System.out.println(">>>>> Attributs de la classe Employe:");
        Field[] fields = employeClass.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f.getName());
        }

        System.out.println(">>>>>>>>> Appel de la méthode identité:");

        //Méthode d'instance:
        //Instancier la classe Employe
        Employe emp = employeClass.getDeclaredConstructor().newInstance(); //appel du constructeur sans params

        Method identiteMethod = employeClass.getMethod("identite");

        identiteMethod.invoke(emp, null);

        Employe emp2 = employeClass.getDeclaredConstructor(String.class, String.class).newInstance("DAWAN", "Jehann");
        identiteMethod.invoke(emp2, null);

    }
}
