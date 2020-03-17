package com.microservices.springsecurityjpa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pos_id")
    private int posId;

    @Column(nullable = false, length=10485760)
    @NotEmpty
    private String pos_title;

    @Column(nullable = false, length=10485760)
    @NotEmpty
    private String pos_text;

    @Column(nullable = false)
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date pos_date;

    @ManyToOne
    private User user;

    public Post(int pos_id, @NotEmpty String pos_title, @NotEmpty String pos_text, @NotEmpty Date pos_date, User user) {
        this.posId = pos_id;
        this.pos_title = pos_title;
        this.pos_text = pos_text;
        this.pos_date = pos_date;
        this.user = user;
    }

    public Post() {
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getPos_title() {
        return pos_title;
    }

    public void setPos_title(String pos_title) {
        this.pos_title = pos_title;
    }

    public String getPos_text() {
        return pos_text;
    }

    public void setPos_text(String pos_text) {
        this.pos_text = pos_text;
    }

    public Date getPos_date() {
        return pos_date;
    }

    public void setPos_date(Date pos_date) {
        this.pos_date = pos_date;
    }

    @JsonManagedReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
