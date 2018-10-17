package pl.waw.placezabaw.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ATTRACTIONS")
public class Attraction {

    @Column(name = "ID", unique = true)
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "ATTRACTION_TYPE_ID")
    private AttractionType attractionType;

    @ManyToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    private Playground playground;

    @Column(name = "QUANTITY")
    @Min(value = 0)
    private int quantity;

    @Column(name = "DESCRIPTION")
    private String description;

    public Attraction(int id, AttractionType attractionType, Playground playground, int quantity, String description) {
        this.id = id;
        this.attractionType = attractionType;
        this.playground = playground;
        this.quantity = quantity;
        this.description = description;
    }

    public Attraction() {
    }


    public int getId() {
        return id;
    }

    public AttractionType getAttractionType() {
        return attractionType;
    }

    public Playground getPlayground() {
        return playground;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setAttractionType(AttractionType attractionType) {
        this.attractionType = attractionType;
    }

    private void setPlayground(Playground playground) {
        this.playground = playground;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
