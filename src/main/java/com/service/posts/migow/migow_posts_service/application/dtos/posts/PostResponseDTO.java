package com.service.posts.migow.migow_posts_service.application.dtos.posts;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Media;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

public class PostResponseDTO implements Serializable {
    private Long reactCount, commentCount, shareCount;
    private UUID id;
    private User owner;
    private Instant createdAt;
    private String text;
    private Set<Media> mediaList;
    private Post sharedPost;

    public PostResponseDTO(Post post,
            Long reactCount, Long commentCount, Long shareCount) {
        this.id = post.getId();
        this.owner = post.getowner();
        this.createdAt = post.getCreatedAt();
        this.text = post.getText();
        this.mediaList = post.getMediaList();
        this.sharedPost = post.getSharedPost();
        this.reactCount = reactCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
    }

    public PostResponseDTO(Long reactCount, Long commentCount, Long shareCount) {
        this.reactCount = reactCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
    }

    public UUID getId() {
        return id;
    }

    public User getOwner() {
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

    public Long getReactCount() {
        return reactCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setReactCount(Long reactCount) {
        this.reactCount = reactCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setOwner(User owner) {
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
}
