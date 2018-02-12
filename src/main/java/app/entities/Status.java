package app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status extends Model{
    private static final long serialVersionUID = 7111683260506175317L;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "status", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<User> userSet=new HashSet<>();

    public Status() {
        super();
    }

    public Status(long id) {
        super(id);
    }

    public Status(String title) {
        this.title = title;
    }

    public Status(long id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status = (Status) o;
        return Objects.equals(title, status.getTitle()) &&
                Objects.equals(userSet, status.getUserSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, userSet);
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
