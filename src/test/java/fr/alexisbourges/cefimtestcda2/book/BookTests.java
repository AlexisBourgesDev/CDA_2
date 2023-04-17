package fr.alexisbourges.cefimtestcda2.book;

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

@SpringBootTest
@AutoConfigureMockMvc
public class BookTests {
    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;
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
        RequestBuilder request = MockMvcRequestBuilders.get("/api/book/all");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();

        List<Book> books = Arrays.asList(objectMapper.readValue(contentAsString, Book[].class));
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
        Book book = new Book("Harry potter");
        RequestBuilder request = MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
    }
}
