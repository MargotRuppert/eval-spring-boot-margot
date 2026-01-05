package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.produit.AllProduitNotFoundException;
import com.adrar.evalspring.exception.produit.ProduitAlreadyExistsException;
import com.adrar.evalspring.exception.produit.ProduitNotFoundException;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProduitService {

    private ProduitRepository produitRepository;

    //ajouter un produit
    public Produit addProduit(Produit produit) {
        if(produitRepository.existsById(produit.getId())) {
            throw new ProduitAlreadyExistsException("Le produit" + produit.getNom() + "existe déjà");
        }
        return produitRepository.save(produit);
    }

    //afficher la liste de tous les produits

    public List<Produit> getAllProduits(){
        if(produitRepository.count() == 0){
            throw new AllProduitNotFoundException("La liste de produit n'existe pas");
        }
        return (List<Produit>) produitRepository.findAll();
    }

    //afficher un produit via son ID
    public Optional<Produit> getProduitById(int id) {
        return Optional
                .of(produitRepository
                        .findById(id)
                        .orElseThrow(()-> new ProduitNotFoundException(
                                        "Le produit avec le id suivant : " + id + " n'existe pas"
                                )
                        )
                );
    }

}
