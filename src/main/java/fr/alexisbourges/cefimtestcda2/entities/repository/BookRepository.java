package fr.alexisbourges.cefimtestcda2.entities.repository;

import fr.alexisbourges.cefimtestcda2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// Créer une interface qui étend JpaRepository pour avoir accès aux méthodes de bases (CRUD)
// 2 types générique à passer à JpaRepository : Classe entité et type de la clé primaire (en général Integer ou Long)
public interface BookRepository extends JpaRepository<Book, Integer> {
}
