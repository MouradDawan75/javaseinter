package fr.dawan.javaintermediare.couchesapplication.helpers;

import fr.dawan.javaintermediare.couchesapplication.dtos.UtilisateurDto;
import fr.dawan.javaintermediare.couchesapplication.entities.Utilisateur;

public class DtoHelper {

    public static UtilisateurDto dtoFromEntity(Utilisateur u) {
            UtilisateurDto dto = new UtilisateurDto();
//            dto.setId(u.getId());
//            dto.setNom(u.getNom());
//            dto.setEmail(u.getEmail());
//            dto.setPassword(u.getPassword());
        //tell don't ask
        dto = u.getDto();
            return dto;
    }
}
