package com.market.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by saniaky on 6/25/14.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, length = 100, unique = true)
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "char(60)")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "char(20)")
    private UserRoleEnum role;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Ad> ads = new ArrayList<Ad>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<UserLike> rating = new ArrayList<UserLike>();

    @Column(name = "likes", nullable = false)
    private Long likes;

    @Column(name = "dislikes", nullable = false)
    private Long dislikes;

    @Column(name = "creation_time", nullable = false)
    private Date creationTime;

    public User(String username, String password, UserRoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
        this.role = UserRoleEnum.USER;
    }

    @PrePersist
    public void prePersist() {
        creationTime = new Date();
        likes = (long) 0;
        dislikes = (long) 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public List<UserLike> getRating() {
        return rating;
    }

    public void setRating(List<UserLike> likes) {
        this.rating = likes;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long like) {
        this.likes = like;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislike) {
        this.dislikes = dislike;
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "id: " + id + ": " + username + ", role = " + role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}
