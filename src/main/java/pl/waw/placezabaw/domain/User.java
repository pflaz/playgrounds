package pl.waw.placezabaw.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Column(name = "ID", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOGIN")
    @NotNull
    private String login;
    @Column(name = "PASSWORD")
    @NotNull
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(
            targetEntity = Playground.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Playground> playgrounds = new ArrayList<>();
    @OneToMany(
            targetEntity = Rate.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rate> rates = new ArrayList<>();

    public User(int id, String name, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(int id, String name, String login, String password, String email, List<Playground> playgrounds, List<Rate> rates) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.playgrounds = playgrounds;
        this.rates = rates;
    }

    public User() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<Playground> getPlaygrounds() {
        return playgrounds;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setId(int id) {
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
