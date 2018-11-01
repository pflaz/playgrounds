package pl.waw.placezabaw.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime ratedDateTime;

    public Rate(int id, User user, Playground playground, int rate, String comment, LocalDateTime ratedDateTime) {
        this.id = id;
        this.user = user;
        this.playground = playground;
        this.rate = rate;
        this.comment = comment;
        this.ratedDateTime = ratedDateTime;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRatedDateTime(LocalDateTime ratedDateTime) {
        this.ratedDateTime = ratedDateTime;
    }
}
