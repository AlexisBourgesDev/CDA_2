package fr.alexisbourges.cefimtestcda2.book;

import fr.alexisbourges.cefimtestcda2.book.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return null;
    }
}
