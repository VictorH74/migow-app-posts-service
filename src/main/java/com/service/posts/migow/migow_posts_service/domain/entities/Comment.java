package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_comment")
public class Comment implements Serializable {

    @EmbeddedId
    final private CommentPK id = new CommentPK();
    @Column(name = "content", nullable = false)
    private String content;
    private Instant createdAt;

    public Comment() {
        this.createdAt = Instant.now();
    }

    public Comment(String content, Instant createdAt) {
        this.content = content;
        this.createdAt = createdAt;
    }

    public CommentPK getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
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
        Comment other = (Comment) obj;
        return Objects.equals(id, other.id);
    }

    

}
