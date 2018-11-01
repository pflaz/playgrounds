package pl.waw.placezabaw.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PLAYGROUNDS")
public class Playground {
    @Column(name = "ID", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(
            targetEntity = Attraction.class,
            mappedBy = "playground",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Attraction> attractions = new ArrayList<>();
    @OneToMany(
            targetEntity = Rate.class,
            mappedBy = "playground",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rate> rates = new ArrayList<>();

    public Playground(int id, User user, String city, String address, String postalCode, double latitude, double longitude, String description) {
        this.id = id;
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


    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

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

    private void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    private void setLongitude(Double longitude) {
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
