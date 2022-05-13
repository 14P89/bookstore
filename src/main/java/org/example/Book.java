package org.example;

import javax.persistence.*;

@Entity
@Table (name = "books")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "title")
    private String title;
    @Column (name = "author")
    private String author;
    @Column (name = "release_year")
    private int releaseYear;
    @Column (name = "number_of_pages")
    private int numberOfPages;

    public Book() {
    }

    public Book(String title, String author, int releaseYear, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
