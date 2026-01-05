package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.categorie.AllCategorieNotFoundException;
import com.adrar.evalspring.exception.categorie.CategorieAlreadyExistsException;
import com.adrar.evalspring.exception.categorie.CategorieNotFoundException;
import com.adrar.evalspring.exception.produit.AllProduitNotFoundException;
import com.adrar.evalspring.exception.produit.ProduitAlreadyExistsException;
import com.adrar.evalspring.exception.produit.ProduitNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    //exception handler pour les produits

    //liste de produit inexistante
    @ExceptionHandler(AllProduitNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAllProduitNotFoundException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    //produit existe déjà
    @ExceptionHandler(ProduitAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleProduitAlreadyExistsException(ProduitAlreadyExistsException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    //Un seul produit pas trouvé
    @ExceptionHandler(ProduitNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProduitNotFoundException(ProduitNotFoundException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.PARTIAL_CONTENT)
                .body(response);
    }


    //exception handler pour les catégories

    //liste de catégorie n'existe pas
    @ExceptionHandler(AllCategorieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAllCategorieNotFoundException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    //catégorie existe déjà
    @ExceptionHandler(CategorieAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategorieAlreadyExistsException(CategorieAlreadyExistsException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    //une catégorie pas trouvée
    @ExceptionHandler(CategorieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategorieNotFoundException(CategorieNotFoundException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.PARTIAL_CONTENT)
                .body(response);
    }
}
