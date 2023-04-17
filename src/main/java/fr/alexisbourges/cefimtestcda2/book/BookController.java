package fr.alexisbourges.cefimtestcda2.book;

import fr.alexisbourges.cefimtestcda2.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/name")
    public List<Book> getBooksByName(@RequestParam String name){
        // return bookService.getBooksByName(name);
        return null;
    }

    @PostMapping("")
    public Book saveBook(@RequestBody Book newBook){
        // return bookService.saveBook(newBook);
        return null;
    }
}
