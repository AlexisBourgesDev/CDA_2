package fr.alexisbourges.cefimtestcda2.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTests {
    @Autowired
    private BookService bookService;

    @Test
    void testHelloBook(){
        assert bookService.helloBook().equals("Hello Book !!!");
    }

}
