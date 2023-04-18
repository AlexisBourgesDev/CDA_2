17/04 10h : 

Créer une classe Livre (titre, description, nbPages, Auteur)
Créer une classe Auteur (nom, prenom, date de naissance[int])
Créer une classe Client (nom, prenom, age, List<Livre>)

Tester la création, suppression et modification des classes

Créer un service et un controller par classe

Ecrire des tests en simulant des appels REST (MockMvc)

Ecrire des tests plus poussé en deserialisant la réponse 

Créer des points d'API GET pour récupérer des listes des 3 classes
Créer des points d'API GET avec des options de filtrage (par nom, par ID ...) en utilisant les différents types de paramètres

Ecrire des points d'API POST, PUT, DELETE pour créer un CRUD complet 

- Ajouter un livre
- Ajouter un livre en lui donnant un auteur, ET vérifier s'il existe déjà, sinon le créé puis créer le livre
- Modifier le nombre de pages d'un livre
- Supprimer un livre par son nom (erreur si plusieurs livres avec le même nom)

18/04 14h

- Ajouter une validation pour avoir un nombre de pages positif
- Ajouter un champ mail pour un client
- Ajouter une validation pour vérifier que l'adresse mail est valide