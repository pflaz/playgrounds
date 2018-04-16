package pl.waw.placezabaw.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ATTRACTIONS_TYPES")
public class AttractionType {
    private int id;
    private String name;
    private List<Attraction> attractions = new ArrayList<>();

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

    @OneToMany(
            targetEntity = Attraction.class,
            mappedBy = "attractionType",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Attraction> getAttractions() {
        return attractions;
    }

    private void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}
