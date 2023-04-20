package fr.alexisbourges.cefimtestcda2.author;

import fr.alexisbourges.cefimtestcda2.book.BookService;
import fr.alexisbourges.cefimtestcda2.entities.Author;
import fr.alexisbourges.cefimtestcda2.entities.Book;
import fr.alexisbourges.cefimtestcda2.entities.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookService bookService;


    public AuthorWithBooks getAuthorWithBooks(int authorId){
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()){
            List<Book> listBooks = bookService.getBooksForAuthor(authorId);
            return new AuthorWithBooks(author.get(), listBooks);
        }
        throw new EntityNotFoundException("Author with ID %d not found".formatted(authorId));
    }
}
