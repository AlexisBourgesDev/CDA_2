package fr.alexisbourges.cefimtestcda2.book;

import fr.alexisbourges.cefimtestcda2.client.model.ClientService;
import fr.alexisbourges.cefimtestcda2.entities.Book;
import fr.alexisbourges.cefimtestcda2.entities.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Permet de définir une classe de Service contenant des traitements
@Service
public class BookService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private BookRepository bookRepository;

    private List<Book> listBook = new ArrayList<>(){{
        add(new Book("Le petit prince", 900));
    }};

    public String helloBook(){
        return "Hello Book !!!";
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    // Via List et classe métier
    public Book saveBookInList(Book newBook) throws InstanceAlreadyExistsException {
        Optional<Book> book = findBook(newBook);
        if (book.isPresent()){
            throw new InstanceAlreadyExistsException(String.valueOf(listBook.indexOf(newBook)));
        }
        listBook.add(newBook);
        return newBook;
    }

    // VIA BDD (Repository)
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> findBook(Book book){
        return listBook.stream().filter(book::equals).findFirst();
    }

    public Book updateNbPages(int id, Integer newNbPages) {
        Book currentBook = listBook.get(id);
        currentBook.setNbPages(newNbPages);
        return currentBook;
    }

    public Book deleteBook(int id) {
        return listBook.remove(id);
    }

    public List<Book> getBooksByName(String name) {
        return listBook.stream().filter(book -> book.getName().contains(name)).toList();
    }
}
