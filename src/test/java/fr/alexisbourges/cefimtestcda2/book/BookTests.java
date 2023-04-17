package fr.alexisbourges.cefimtestcda2.book;

import fr.alexisbourges.cefimtestcda2.book.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BookTests {
    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

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
        mockMvc.perform(request)
                .andExpect(resultStatus);
    }
}
