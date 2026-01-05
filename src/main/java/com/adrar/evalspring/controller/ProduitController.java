package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProduitController {

    private ProduitService produitService;

    //récupération de tous les produits

    @GetMapping("/produits")
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
    //récupération d'un produit via l'id
    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produit> getProduit(@PathVariable Integer id){
        return produitService.getProduitById(id);
    }

    //ajouter un produit
    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit saveProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }
}
