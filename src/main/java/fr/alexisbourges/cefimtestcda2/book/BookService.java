package fr.alexisbourges.cefimtestcda2.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<String> listBook = new ArrayList<>(){{
        add("Le petit prince");
    }};

    public String helloBook(){
        return "Hello Book !!!";
    }
}
