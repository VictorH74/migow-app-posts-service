package com.service.posts.migow.migow_posts_service.application.dtos.comments;

import java.time.Instant;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public class CommentResponseDTO {
    private UUID id;
    private User owner;
    private UUID postId;
    private String content;
    private Instant createdAt;
    private Long reactCount;
    private Long replyCommentCount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getReactCount() {
        return reactCount;
    }

    public void setReactCount(Long reactCount) {
        this.reactCount = reactCount;
    }

    public Long getReplyCommentCount() {
        return replyCommentCount;
    }

    public void setReplyCommentCount(Long replyCommentCount) {
        this.replyCommentCount = replyCommentCount;
    }

}
