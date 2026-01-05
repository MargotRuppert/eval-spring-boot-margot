package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="categorie")
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull(message = "Le champs ne peut pas être vide")
    @Length(min = 2, message = "Le libellé ne peut pas faire moins de deux caractères")
    private String libelle;
}
