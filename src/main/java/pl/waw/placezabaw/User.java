package pl.waw.placezabaw;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private List<Playground> playgrounds = new ArrayList<>();

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User() {
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

    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @OneToMany(
            targetEntity = Playground.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Playground> getPlaygrounds() {
        return playgrounds;
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

    private void setPlaygrounds(List<Playground> playgrounds) {
        this.playgrounds = playgrounds;
    }
}
