LIBRAIRIE UTILES :

- LOMBOK


17/04 10h
=========

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
=========

- Ajouter une validation pour avoir un nombre de pages positif
- Ajouter un champ mail pour un client
- Ajouter une validation pour vérifier que l'adresse mail est valide

18/04 15h
=========

<<BACKLOG>>

Je veux stocker une liste de livres avec un titre, une description, un nombre de pages et un état du livre (NEUF, BON ETAT, ABIME ...). 
Chaque livre a un genre littéraire ayant un nom (fantastique, policier ...) et un auteur (nom, prenom, date de naissance)
On aura une liste de clients, identifiés par un nom, prénom, adresse mail et âge
On peut écrire des avis sur un livre (plusieurs par livre) avec pour chaque avis, une note de 1 à 10 (pas de 0 possible et pas de 1.5)
Chaque client pourra réserver un ou plusieurs livres (3 max en même temps) et on pourra retrouver l'historique des réservations d'un client

BUT : Transformer les classes métiers -> Entités 
Compléter le code pour intégrer le backlog

20/04 10h
=========

Etapes pour créer une classe composite :

Création d'une classe composite Auteur avec ses livres (AuthorWithBooks) avec un auteur et sa liste de livres
Création d'un point d'API dans AuthorController pour avoir un ID d'auteur
Création d'une méthode principal dans AuthorService pour récupérer l'auteur et si il existe : 
- Demander à BookService la liste des livres qui ont comme auteur identifié par ID
Merger dans la méthode de AuthorService l'auteur + la liste de livres et la renvoyer 
Gestion du cas où un auteur n'est pas trouvé

