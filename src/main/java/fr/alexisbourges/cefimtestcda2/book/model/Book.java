package fr.alexisbourges.cefimtestcda2.book.model;

import java.util.Objects;

// Classe de données
// Bien penser à initialiser un constructeur vide + setter pour la désérialisation (CLIENT -> API)
// Bien penser à initialiser les getter pour la sérialisation (API -> CLIENT)
public class Book {
    private String title;
    private Integer nbPages;

    public Book(String title) {
        this(title, 0);
    }

    public Book(String title, Integer nbPages) {
        this.title = title;
        this.nbPages = nbPages;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    // Redéfinition de equals pour tester l'égalité entre 2 instances
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(nbPages, book.nbPages);
    }

    // Entier pour gérer la notion d'unicité par exemple dans les Set ou les Map
    @Override
    public int hashCode() {
        return Objects.hash(title, nbPages);
    }
}
