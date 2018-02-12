package app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book_category")
public class BookCategory extends Model {
    private static final long serialVersionUID = -6711209072421253224L;

    @Column(name = "title",length = 100)
    private String title;

    @OneToMany(mappedBy = "bookCategory", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet();

    public BookCategory() {
        super();
    }

    public BookCategory(String title) {
        this.title = title;
    }

    public BookCategory(long id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(getClass()!=obj.getClass()||obj==null)return false;
        BookCategory bookCategory = (BookCategory)obj;
        if(title!=null? !title.equals(bookCategory.getTitle()):bookCategory.getTitle()!=null)return false;
        return books!=null? books.equals(bookCategory.getBooks()):bookCategory.getBooks()==null;
    }
}
