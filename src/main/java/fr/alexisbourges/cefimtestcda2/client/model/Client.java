package fr.alexisbourges.cefimtestcda2.client.model;

import fr.alexisbourges.cefimtestcda2.book.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private List<Book> listBooks;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
        this.listBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(listBooks, client.listBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, listBooks);
    }
}
