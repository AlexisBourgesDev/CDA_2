package fr.alexisbourges.cefimtestcda2.book;

import fr.alexisbourges.cefimtestcda2.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotation pour définir un nouveau controller (qui va contenir une liste de points d'API)
@RestController
// Ajout d'un préfixe à tout nos points d'API
@RequestMapping("/api/book")
public class BookController {

    // Injection de notre classe de service
    @Autowired
    private BookService bookService;

    // Création d'un point d'API : [GET] /api/book/all
    // On concatène le préfixe au point d'API spécifié
    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    // Récupération d'un paramètre GET : /api/book/name?name:prince
    // Dans ce cas, notre paramètre GET name aura pour valeur prince
    @GetMapping("/name")
    public List<Book> getBooksByName(@RequestParam String name){
        // return bookService.getBooksByName(name);
        return null;
    }

    // Création d'un point d'API : [POST] /api/book
    // @RequestBody va désérialiser le contenu JSON dans un format objet Java
    @PostMapping("")
    public Book saveBook(@RequestBody Book newBook){
        // return bookService.saveBook(newBook);
        return null;
    }
}
