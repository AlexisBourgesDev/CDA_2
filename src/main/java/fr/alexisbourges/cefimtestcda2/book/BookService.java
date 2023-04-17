package fr.alexisbourges.cefimtestcda2.book;

import fr.alexisbourges.cefimtestcda2.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> listBook = new ArrayList<>(){{
        add(new Book("Le petit prince"));
    }};

    public String helloBook(){
        return "Hello Book !!!";
    }

    public List<Book> getAll(){
        return listBook;
    }
}
