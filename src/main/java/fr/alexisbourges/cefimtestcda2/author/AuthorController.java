package fr.alexisbourges.cefimtestcda2.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @GetMapping("/{id}")
    public AuthorWithBooks getAuthorWithBooks(@PathVariable("id") Integer authorId){
        return authorService.getAuthorWithBooks(authorId);
    }
}
