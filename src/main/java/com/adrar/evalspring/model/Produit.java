package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="produit")
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull(message = "Le champs ne peut pas être vide")
    @Length(min= 2, message = "Le nom ne peut pas faire moins de deux caractères")
    private String nom;

    @Column(nullable = false)
    @NotNull(message = "Le champs ne peut pas être vide")
    @Positive(message = "On ne peut pas mettre de nombre négatif")
    private int prix;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
