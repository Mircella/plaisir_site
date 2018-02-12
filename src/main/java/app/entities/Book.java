package app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends Model {
    private static final long serialVersionUID = 3932097849269684776L;

    @Column(name = "title",length = 255)
    private String title;

    @Column(name = "description", length = 10000)
    private String description;

    @Column(name = "year", length = 6)
    private int year;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private BookCategory bookCategory;

    @ManyToMany(mappedBy = "bookSet",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<User> userSet = new HashSet<>();

    public Book() {
        super();
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String description, int year, BookCategory bookCategory) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.bookCategory = bookCategory;
    }

    public Book(long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getYear() == book.getYear() &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getDescription(), book.getDescription()) &&
                Objects.equals(getBookCategory(), book.getBookCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getYear(), getBookCategory());
    }

}
