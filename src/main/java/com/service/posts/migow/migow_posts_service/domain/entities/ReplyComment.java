package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.domain.pks.ReplyCommentPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

public class ReplyComment implements Serializable {
    @EmbeddedId
    final private ReplyCommentPK id = new ReplyCommentPK();
    @Column(name = "content", nullable = false)
    private String content;
    private Instant createdAt;

    public ReplyComment() {
        this.createdAt = Instant.now();
    }

    public ReplyComment(String content, Instant createdAt) {
        this.content = content;
        this.createdAt = createdAt;
    }

    public ReplyCommentPK getId() {
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
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReplyComment other = (ReplyComment) obj;
        return Objects.equals(id, other.id);
    }

}
