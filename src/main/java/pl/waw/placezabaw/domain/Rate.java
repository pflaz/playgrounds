package pl.waw.placezabaw.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "RATES")
public class Rate {
    @Column(name = "ID", unique = true)
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    private Playground playground;
    @Column(name = "RATE")
    @NotNull
    private int rate;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "RATED_DATE_TIME")
    @NotNull
    private LocalDateTime ratedDateTime;

    public Rate(int id, User user, Playground playground, int rate, String comment) {
        this.id = id;
        this.user = user;
        this.playground = playground;
        this.rate = rate;
        this.comment = comment;
        this.ratedDateTime = LocalDateTime.now();
    }

    public Rate() {
    }


    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Playground getPlayground() {
        return playground;
    }

    public int getRate() {
        return rate;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getRatedDateTime() {
        return ratedDateTime;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setPlayground(Playground playground) {
        this.playground = playground;
    }

    private void setRate(int rate) {
        this.rate = rate;
    }

    private void setComment(String comment) {
        this.comment = comment;
    }

    private void setRatedDateTime(LocalDateTime ratedDateTime) {
        this.ratedDateTime = ratedDateTime;
    }
}
