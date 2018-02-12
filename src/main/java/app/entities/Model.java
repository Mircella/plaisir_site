package app.entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
abstract class Model implements Serializable {
    private static final long serialVersionUID = -3543306342871447546L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",length = 11)
    private long id;

    public Model() {
    }

    public Model(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
