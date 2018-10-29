package pl.waw.placezabaw.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ATTRACTIONS_TYPES")
public class AttractionType {

    @Column(name = "ID", unique = true)
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Attraction.class,
            mappedBy = "attractionType",
            fetch = FetchType.LAZY
    )
    private List<Attraction> attractions = new ArrayList<>();

    public AttractionType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AttractionType() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
