package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CategorieController {

    private CategorieService categorieService;

    //récupération de toutes les catégories
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Categorie> getAllCategories(){
        return categorieService.getAllCategories();
    }

    //récupération d'une catégorie avec son ID
    @GetMapping("/categorie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Categorie> getCategorie(@PathVariable Integer id){
        return categorieService.getCategorieById(id);
    }

    //ajout d'une catégorie
    @PostMapping("/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie saveCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    }
}
