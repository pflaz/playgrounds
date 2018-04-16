package pl.waw.placezabaw;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "RATES")
public class Rate {
    private int id;
    private User user;
    private Playground playground;
    private int rate;
    private String comment;
    private LocalDateTime ratedDateTime;

    public Rate(User user, Playground playground, int rate, String comment) {
        this.user = user;
        this.playground = playground;
        this.rate = rate;
        this.comment = comment;
        this.ratedDateTime = LocalDateTime.now();
    }

    public Rate() {
    }

    @Column(name = "ID", unique = true)
    @NotNull
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    public Playground getPlayground() {
        return playground;
    }

    @Column(name = "RATE")
    @NotNull
    public int getRate() {
        return rate;
    }

    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    @Column(name = "RATED_DATE_TIME")
    @NotNull
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
