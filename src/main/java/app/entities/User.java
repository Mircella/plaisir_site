package app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Model{
    private static final long serialVersionUID = 7599532222740025415L;

    @Column(name = "login",length = 255)
    private String login;
    @Column(name = "email",length = 300)
    private String email;
    @Column(name = "password",length = 30)
    private String password;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_books",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false),
    inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = true))
    private Set<Book> bookSet = new HashSet<>();

    public User() {
    }

    public User(long id) {
        super(id);
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String email, String password,Status status) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(login, user.getLogin()) &&
                Objects.equals(email, user.getEmail()) &&
                Objects.equals(password, user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password);
    }
}
