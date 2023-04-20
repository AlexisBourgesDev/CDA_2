package fr.alexisbourges.cefimtestcda2.entities.repository;

import fr.alexisbourges.cefimtestcda2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Créer une interface qui étend JpaRepository pour avoir accès aux méthodes de bases (CRUD)
// 2 types générique à passer à JpaRepository : Classe entité et type de la clé primaire (en général Integer ou Long)

public interface BookRepository extends JpaRepository<Book, Integer> {
    // Génération de requêtes via nommage de méthode : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Book> findByNameContainingIgnoreCase(String name);

    // Remplacement des paramètres de la méthode par ordre
    @Query("select b from Book b where b.nbPages > ?1")
    List<Book> findByBooks(Integer nbPages);
    // Remplacement des paramètres par noms
    @Query("select b from Book b where b.nbPages > :minimumPages")
    List<Book> findByBigBooksByAlias(@Param("minimumPages") Integer nbPages);

    List<Book> findByAuthorId(int authorId);



}
