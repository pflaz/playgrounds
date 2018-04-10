package pl.waw.placezabaw;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "PLAYGROUNDS")
public class Playground {
    private int id;
    private User user;
    private String city;
    private String address;
    private String postalCode;
    private double latitude;
    private double longitude;
    private String description;
    private List<Attraction> attractions = new ArrayList<>();
    private List<Rate> rates = new ArrayList<>();

    public Playground(User user, String city, String address, String postalCode, double latitude, double longitude, String description) {
        this.user = user;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longitude = longitude;
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

    @Column(name = "LATITUDE")
    public double getLatitude() {
        return latitude;
    }

    @Column(name = "LONGITUDE")
    public double getLongitude() {
        return longitude;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = Attraction.class,
            mappedBy = "playground",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Attraction> getAttractions() {
        return attractions;
    }

    @OneToMany(
            targetEntity = Rate.class,
            mappedBy = "playground",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Rate> getRates() {
        return rates;
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

    private void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    private void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
