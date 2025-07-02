package fr.dawan.javaintermediare.couchesapplication.services;

import fr.dawan.javaintermediare.couchesapplication.dtos.UtilisateurDto;

import java.util.List;

public interface IUtilisateurService {
    List<UtilisateurDto> getAll();

    void save(UtilisateurDto utilisateurDto);

    void delete(UtilisateurDto utilisateurDto);
}
