package pl.waw.placezabaw;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "PLAYGROUNDS")
public class Playground {
    private int id;
    private User user;
    private String city;
    private String address;
    private String postalCode;
    private String description;

    public Playground(User user, String city, String address, String postalCode, String description) {
        this.user = user;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.description = description;
    }

    public Playground() {
    }

    @Column(name = "ID", unique = true)
    @NotNull
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @ManyToOne (
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    @Column(name = "POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
