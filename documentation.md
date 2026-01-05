Différents end-points du projet

<!-- Ajout d'une catégorie valide -->
POST "http://localhost:9000/categorie"

{"id": "1",
"libelle" : "bonbon"}

<!-- ajout d'une catégorie non valide -->
{"id": "1",
"libelle" : "t"}

POST "http://localhost:9000/produit"
<!-- ajout d'un produit valide -->

{"id": "1",
"nom": "malabar",
"prix": "5",
    {"id": "1",
    "libelle" : "bonbon"}
}

<!-- ajout d'un produit non valide -->
{"id": "1",
"nom": "m",
"prix": "-2",
{"id": "1",
"libelle" : "bonbon"}
}

<!-- affichage de la liste de produits -->
GET "http://localhost:9000/produits"


<!-- affichage d'une catégorie par son ID -->
GET "http://localhost:9000/categorie/1"