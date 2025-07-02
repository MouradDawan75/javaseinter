package fr.dawan.javaintermediare.couchesapplication.ihm;

import fr.dawan.javaintermediare.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.javaintermediare.couchesapplication.repositories.UtilisateurRepositoryImpl;
import fr.dawan.javaintermediare.couchesapplication.services.IUtilisateurService;
import fr.dawan.javaintermediare.couchesapplication.services.UtilisateurService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class application {

    public static void main(String[] args) {
        IUtilisateurService service = new UtilisateurService(new UtilisateurRepositoryImpl());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    >>>>>>>>>>>>>>>>>> Menu:
                    1- Afficher la liste des utilisateurs
                    2- Ajouter un utilistauer
                    3- Supprimer un utilisateur
                    4- Quitter
                    """);

            int choix = sc.nextInt();
            if(choix == 4){
                System.out.println(">>>>>>>> Fin de l'application...");
                break;
            }

            if(choix == 1){
                List<UtilisateurDto> lst =service.getAll();
                lst.stream().forEach(System.out::println);
            }

            if(choix == 2){
                System.out.println("Id: ");
                int id = sc.nextInt();
                System.out.println("Nom: ");
                String nom = sc.next();
                System.out.println("Email: ");
                String email = sc.next();
                System.out.println("Password: ");
                String pwd = sc.next();

                UtilisateurDto dto = new UtilisateurDto();
                dto.setId(id);
                dto.setNom(nom);
                dto.setEmail(email);
                dto.setPassword(pwd);

                service.save(dto);
                System.out.println("Utilisateur ajouté..........");
            }

            if(choix == 3){
                System.out.println("Id: ");
                int id = sc.nextInt();
                List<UtilisateurDto> lst = service.getAll()
                        .stream()
                        .filter(u -> u.getId() == id)
                        .collect(Collectors.toList());

                if(lst.size() > 0){
                    service.delete(lst.get(0));
                    System.out.println("Utiistateur supprimé.........");
                }else{
                    System.out.println("Utilistauer introuvable..........");
                }
            }

        }

    }
}
