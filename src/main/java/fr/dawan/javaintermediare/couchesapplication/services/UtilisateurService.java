package fr.dawan.javaintermediare.couchesapplication.services;

import fr.dawan.javaintermediare.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.javaintermediare.couchesapplication.entities.Utilisateur;
import fr.dawan.javaintermediare.couchesapplication.helpers.MapperTool;
import fr.dawan.javaintermediare.couchesapplication.repositories.IUtilisateurRepository;

import java.util.ArrayList;
import java.util.List;


/*
Le service (couche métier): son rôle est de gérer les règles métiers et répondre aux besoins des utilistauers finaux.
Contient les fonctionnalités de l'application.
 */

public class UtilisateurService implements IUtilisateurService {

    private IUtilisateurRepository repository;

    public UtilisateurService(IUtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UtilisateurDto> getAll(){
        List<UtilisateurDto> result = new ArrayList<>();
        List<Utilisateur> users = repository.getAll();

        //conversion des entities en dto
        for(Utilisateur u : users){
//            UtilisateurDto dto = new UtilisateurDto();
//            dto.setId(u.getId());
//            dto.setNom(u.getNom());
//            dto.setEmail(u.getEmail());
//            dto.setPassword(u.getPassword());

            //Option1: déleguer cette tâche à une autre classe (Single Of Responsability)
            //UtilisateurDto dto  = DtoHelper.dtoFromEntity(u);

            //Option2: utiliser des librairies externes: ModelMapper - MapStruct

            UtilisateurDto dto = MapperTool.convert(u, UtilisateurDto.class);

            result.add(dto);
        }

        return result;
    }

    @Override
    public void save(UtilisateurDto utilisateurDto){
        Utilisateur u = MapperTool.convert(utilisateurDto, Utilisateur.class);
        repository.save(u);

    }

    @Override
    public void delete(UtilisateurDto utilisateurDto){
        Utilisateur u = MapperTool.convert(utilisateurDto, Utilisateur.class);
        repository.delete(u);
    }
}
