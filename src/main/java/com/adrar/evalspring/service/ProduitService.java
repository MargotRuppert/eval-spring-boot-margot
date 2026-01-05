package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.produit.AllProduitNotFound;
import com.adrar.evalspring.exception.produit.ProduitAlreadyExists;
import com.adrar.evalspring.exception.produit.ProduitNotFound;
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
            throw new ProduitAlreadyExists("Le produit" + produit.getNom() + "existe déjà");
        }
        return produitRepository.save(produit);
    }

    //afficher la liste de tous les produits

    public List<Produit> getAllProduits(){
        if(produitRepository.count() == 0){
            throw new AllProduitNotFound("La liste de produit n'existe pas");
        }
        return (List<Produit>) produitRepository.findAll();
    }

    //afficher un produit via son ID
    public Optional<Produit> getProduitById(int id) {
        if(produitRepository.existsById(id)) {
            throw new ProduitNotFound("Le produit n'existe pas");
        }
        return produitRepository.findById(id);
    }

}
