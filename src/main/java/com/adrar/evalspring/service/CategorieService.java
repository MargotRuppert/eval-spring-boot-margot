package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.categorie.AllCategorieNotFoundException;
import com.adrar.evalspring.exception.categorie.CategorieAlreadyExistsException;
import com.adrar.evalspring.exception.categorie.CategorieNotFoundException;
import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieService {

    private CategorieRepository categorieRepository;

    //ajouter une catégorie
    public Categorie addCategorie(Categorie categorie) {
        if(categorieRepository.existsById(categorie.getId())) {
            throw new CategorieAlreadyExistsException("la catégorie: " + categorie.getId() + "existe déjà");
        }
        return categorieRepository.save(categorie);
    }

    //afficher toutes les catégories
    public List<Categorie> getAllCategories() {
        if(categorieRepository.count() == 0) {
            throw new AllCategorieNotFoundException("la liste des catégories n'existe pas");
        }
        return (List<Categorie>) categorieRepository.findAll();
    }

    //affficher une catégorie via son ID
    public Optional<Categorie> getCategorieById(Integer id){
        return Optional
                .of(categorieRepository
                        .findById(id)
                        .orElseThrow(()-> new CategorieNotFoundException(
                                        "La catégorie avec le id suivant : " + id + " n'existe pas"
                                )
                        )
                );
    }
}
