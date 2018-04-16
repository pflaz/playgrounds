package pl.waw.placezabaw.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ATTRACTIONS")
public class Attraction {
    private int id;
    private AttractionType attractionType;
    private Playground playground;
    private int quantity;
    private String description;

    public Attraction(AttractionType attractionType, Playground playground, int quantity, String description) {
        this.attractionType = attractionType;
        this.playground = playground;
        this.quantity = quantity;
        this.description = description;
    }

    public Attraction() {
    }

    @Column(name = "ID", unique = true)
    @NotNull
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "ATTRACTION_TYPE_ID")
    public AttractionType getAttractionType() {
        return attractionType;
    }

    @ManyToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    public Playground getPlayground() {
        return playground;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "DESCRIPTION")
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
