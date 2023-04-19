package fr.alexisbourges.cefimtestcda2.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    // select book.* from book inner join author on author.id = book.author_id;
    // @OneToMany
    // targetEntity : Class<?> de l'entité cible
    // mappedBy : Nom de l'attribut annoté de @ManyToOne
    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private List<Book> books;


    public Author() {
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
}
