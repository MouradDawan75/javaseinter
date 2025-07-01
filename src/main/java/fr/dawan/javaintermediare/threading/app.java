package fr.dawan.javaintermediare.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class app {

    static int total = 0;

    public static void main(String[] args) throws Exception {
        /*
        Processus: un programme en cours d'exécution
        Thread: est un composant physique permettant l'exécution de tâches
         */

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
            /*
            Tâche lente
             */
                System.out.println("Tâche1..........."+Thread.currentThread().getName());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
            /*
            Tâche lente
             */
                System.out.println("Tâche2..........."+Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join(); //join: mets en attente le main thread

        System.out.println("Tâche principale............."+Thread.currentThread().getName());
        /*
        Le multi threading permet de créer des applications résponsives (multi tâches)
         */

        System.out.println(">>>>>>>> Accès concurrentiel à des ressources partagées:");

        Thread th1 = new Thread(app::addMillion);
        Thread th2 = new Thread(app::addMillion);
        Thread th3 = new Thread(app::addMillion);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println("Total = "+total);

        /*
        Lancer la copie de 100 fichiers en parallèl
         */

        ExecutorService executor = Executors.newFixedThreadPool(2); //un réservoir de Threads (ThreadPool)

        /*
        Si aucun thread n'est disponible, la tâche sera mise en file d'attente
         */

        String src1 = "a.txt";
        String src2 = "b.txt";
        String src3 = "c.txt";

        String cible1 = "e.txt";
        String cible2 = "f.txt";
        String cible3 = "g.txt";

        Thread copy1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy1..........."+Thread.currentThread().getName());
                try {
                    FileHelper.copieFichier(src1, cible1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread copy2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy2..........."+Thread.currentThread().getName());
                try {
                    FileHelper.copieFichier(src2, cible2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread copy3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy3..........."+Thread.currentThread().getName());
                try {
                    FileHelper.copieFichier(src3, cible3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(copy1);
        executor.execute(copy2);
        executor.execute(copy3);

        /*
        Exécuter une tâche asynchrone et récupérer le résultat final de tâche en question
        Pas possible avec le type Thread car Runnable est une void
        Dans ThreadPool, la méthode submit renvoie le résultat de la tâche asynchrone
         */

        int a = 15, b = 11;

        int resultat = 0;

       Future<Integer> future =  executor.submit(new Callable<Integer>() {
           @Override
           public Integer call() throws Exception {
               Thread.sleep(5000); //simuler une tâche lente
               return a + b;
           }
       });

       //Comment savoir si lâche asynchrone a fini son exécution

        while(!future.isDone()){
            System.out.println("Tâche en cours...................");
        }

        resultat = future.get();

        System.out.println("Résultat final = "+resultat);

        executor.shutdown(); //libérer les threads du réservoir

    }

    /*
    Synchronized: demande au Thread qui exécute cette méthode de vérrouiller l'accès à la méthode en question
     */
    synchronized static void addMillion(){
        for (int i = 0; i < 100000; i++) {
            total++;
        }
    }
}
