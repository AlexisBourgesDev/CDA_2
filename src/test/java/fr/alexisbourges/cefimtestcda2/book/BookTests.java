package fr.alexisbourges.cefimtestcda2.book;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.alexisbourges.cefimtestcda2.book.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Annotation pour préciser que cette classe contient des tests
@SpringBootTest
// Permet au MockMvc de se configurer pour attaquer notre API
@AutoConfigureMockMvc
public class BookTests {
    @Autowired
    private BookService bookService;

    // Classe pour simuler des appels REST
    @Autowired
    private MockMvc mockMvc;

    // Classe de sérialisation / désérialisation
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testHelloBook(){
        assert bookService.helloBook().equals("Hello Book !!!");
    }
    @Test
    void testGetAllBook(){
        assert bookService.getAll().contains(new Book("Le petit prince"));
    }

    @Test
    void testGetAllBookByAPI() throws Exception {
        // Création de notre requête au moyen de la classe MockMvcRequestBuilders
        // Utilisation de la méthode correspondant au verbe HTTP voulu, qui prend en paramètre l'URL du point d'API
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/all");
        // Test du status de la réponse, ici 200 (isOk())
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();

        // Désérialisation du contenu de la réponse en List<Book>
        List<Book> books = Arrays.asList(objectMapper.readValue(contentAsString, Book[].class));
        // OU
        List<Book> books2 = objectMapper.readValue(contentAsString, new TypeReference<>() {});
        // Pour un seul livre en réponse
        // Book oneBook = objectMapper.readValue(contentAsString, Book.class);
        assert books.contains(new Book("Le petit prince"));
    }

    @Test
    void testGetBookPrince() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/name?name=prince");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();

        List<Book> books = Arrays.asList(objectMapper.readValue(contentAsString, Book[].class));
        assert books.contains(new Book("Le petit prince"));
    }

    @Test
    void testPostBook() throws Exception {
        // Pour envoyer un livre, bien penser à indiquer le type du contenu du body (JSON = .contentType(MediaType.APPLICATION_JSON)
        // Et à serialiser le contenu (.content(objectMapper.writeValueAsString(book)))
        Book book = new Book("Harry potter");
        RequestBuilder request = MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();

        Book newBook = objectMapper.readValue(contentAsString, Book.class);
        assert newBook.equals(book);
    }

    @Test
    void testPostBookFailed() throws Exception {
        Book book = bookService.getAll().get(0);
        RequestBuilder request = MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isConflict();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();

        Book newBook = objectMapper.readValue(contentAsString, Book.class);
        assert newBook.equals(book);
    }

    @Test
    void testPatchBook() throws Exception {
        int firstBookNbPages = bookService.getAll().get(0).getNbPages().intValue();
        Integer newNbPages = firstBookNbPages + 1;

        RequestBuilder request = MockMvcRequestBuilders.patch("/api/book/0/pages").contentType(MediaType.APPLICATION_JSON).content(newNbPages.toString());

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request).andExpect(resultStatus);

        Book newBook = bookService.getAll().get(0);
        assert !Objects.equals(newBook.getNbPages(), firstBookNbPages);
        assert newBook.getNbPages().equals(newNbPages);
    }

    @Test
    void testDeleteBook() throws Exception {
        int nbBooks = bookService.getAll().size();

        RequestBuilder request = MockMvcRequestBuilders.delete("/api/book/0");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request).andExpect(resultStatus);

        List<Book> listBooksAfterDelete = bookService.getAll();
        assert nbBooks - 1 == listBooksAfterDelete.size();
    }
}
