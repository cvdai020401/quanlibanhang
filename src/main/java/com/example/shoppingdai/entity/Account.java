package com.example.shoppingdai.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {
    @Id
    @Column(name = "Username", nullable = false, length = 50)
    @NotEmpty(message = "Không để trống username")
    private String id;

    @Column(name = "Password", nullable = false, length = 50)
    @NotEmpty(message = "Không để trống password")
    private String password;

    @Column(name = "Fullname", nullable = false, length = 50)
    private String fullname;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Photo", nullable = false, length = 50)
    private String photo;

    @Column(name = "Activated", nullable = false)
    private Boolean activated = true;

    @Column(name = "Admin", nullable = false)
    private Boolean admin = false;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}