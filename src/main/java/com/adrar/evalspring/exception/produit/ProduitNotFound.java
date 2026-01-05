package com.adrar.evalspring.exception.produit;

public class ProduitNotFound extends RuntimeException {
    public ProduitNotFound(String message) {
        super(message);
    }
}
