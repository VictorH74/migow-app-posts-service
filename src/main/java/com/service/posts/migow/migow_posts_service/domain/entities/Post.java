package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_post")
public class Post implements  Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private Instant createdAt;
    private String text;

    @OneToMany
    @JoinColumn(name = "media_list")
    private Set<Media> mediaList;

    @Column(name="shared_post_id", nullable = true)
    private Post sharedPost;

    public Post() {
        this.createdAt = Instant.now();
    }

    public Post(UUID id, User owner, Instant createdAt, String text, Set<Media> mediaList, Post sharedPost) {
        this.id = id;
        this.owner = owner;
        this.createdAt = createdAt;
        this.text = text;
        this.mediaList = mediaList;
        this.sharedPost = sharedPost;
    }

    public UUID getId() {
        return id;
    }

    public User getowner() {
        return owner;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getText() {
        return text;
    }

    public Set<Media> getMediaList() {
        return mediaList;
    }

    public Post getSharedPost() {
        return sharedPost;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setowner(User owner) {
        this.owner = owner;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMediaList(Set<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public void setSharedPost(Post sharedPost) {
        this.sharedPost = sharedPost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        return Objects.equals(id, other.id);
    }
}
