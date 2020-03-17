package com.microservices.springsecurityjpa.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "use_id")
    private int useId;
    @Column(name="use_username", nullable=false)
    @NotEmpty()
    private String userName;
    @Column(nullable=false)
    @NotEmpty()
    @Size(min=4)
    private String use_password;
    @Column(nullable=false)
    @NotEmpty()
    private boolean use_active;
    @ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns={@JoinColumn(name="uro_use_id", referencedColumnName="use_id")},
            inverseJoinColumns={@JoinColumn(name="uro_rol_id", referencedColumnName="rol_id")})
    private List<Rol> roles;

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUse_password() {
        return use_password;
    }

    public void setUse_password(String use_password) {
        this.use_password = use_password;
    }

    public boolean isUse_active() {
        return use_active;
    }

    public void setUse_active(boolean use_active) {
        this.use_active = use_active;
    }

    @JsonBackReference
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
