package pl.waw.placezabaw.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private List<Playground> playgrounds = new ArrayList<>();
    private List<Rate> rates = new ArrayList<>();

    public User(int id, String name, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    @Column(name = "ID", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @OneToMany(
            targetEntity = Playground.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Playground> getPlaygrounds() {
        return playgrounds;
    }

    @OneToMany(
            targetEntity = Rate.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Rate> getRates() {
        return rates;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPlaygrounds(List<Playground> playgrounds) {
        this.playgrounds = playgrounds;
    }

    private void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
