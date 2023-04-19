package fr.alexisbourges.cefimtestcda2.entities;

import jakarta.persistence.*;

// @Entity -> Classe lié à une table dans la BDD
@Entity
// @Table -> Nom de la table à lier à l'entité
@Table(name = "book")
public class Book {
    // @Id : Spécifie que l'attribut qui suit sera
    @Id
    // @GeneratedValue : Auto increment (IDENTITY) géré par le SGBD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Définir le nom de la colonne à rattacher à l'attribut de la classe
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "nb_pages")
    private Integer nbPages;

    // Paramètre fetch de @ManyToOne
    // EAGER (default) : Récupération de l'auteur en même temps que le Book
    // LAZY : Récupération différé au moment où on accède à cet attribut
    @ManyToOne
    @JoinColumn(name = "author_id", updatable = false, insertable = false)
    private Author author;



    public Book() {
    }

    public Book(String name) {
        this(name, 0);
    }

    public Book(String name, Integer nbPages) {
        this.name = name;
        this.nbPages = nbPages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }
}
