package com.adrar.evalspring.exception.produit;

public class ProduitAlreadyExistsException extends RuntimeException {
    public ProduitAlreadyExistsException(String message) {
        super(message);
    }
}
