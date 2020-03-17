package com.microservices.springsecurityjpa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int com_id;

    @Column(nullable = false, length=10485760)
    @NotEmpty
    private String com_text;

    @Column(nullable = false)
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date com_date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    public Comment(int com_id, @NotEmpty String com_text, @NotEmpty Date com_date, User user, Post post) {
        this.com_id = com_id;
        this.com_text = com_text;
        this.com_date = com_date;
        this.user = user;
        this.post = post;
    }

    public Comment() {
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_text() {
        return com_text;
    }

    public void setCom_text(String com_text) {
        this.com_text = com_text;
    }

    public Date getCom_date() {
        return com_date;
    }

    public void setCom_date(Date com_date) {
        this.com_date = com_date;
    }

    @JsonManagedReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonManagedReference
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
