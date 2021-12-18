package model;


import javax.persistence.*;

@Entity
@Table(name="rdbip_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String authorName;
    private String genre;
    private String publishDate;
    private String annotation;
    private String isbn;

    public Book(String name, String authorName, String genre, String publishDate, String annotation, String isbn) {
        this.name = name;
        this.authorName = authorName;
        this.genre = genre;
        this.publishDate = publishDate;
        this.annotation = annotation;
        this.isbn = isbn;
    }

    public Book() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
