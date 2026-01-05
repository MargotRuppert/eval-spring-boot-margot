package com.adrar.evalspring.exception.produit;

public class ProduitAlreadyExists extends RuntimeException {
    public ProduitAlreadyExists(String message) {
        super(message);
    }
}
