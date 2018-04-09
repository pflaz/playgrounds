package pl.waw.placezabaw;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ATTRACTIONS_TYPES")
public class AttractionType {
    private int id;
    private String name;

    public AttractionType(String name) {
        this.name = name;
    }

    public AttractionType() {
    }

    @Column(name = "ID", unique = true)
    @NotNull
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
