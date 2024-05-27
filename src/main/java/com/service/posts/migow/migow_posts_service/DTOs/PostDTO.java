package com.service.posts.migow.migow_posts_service.DTOs;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.entities.Media;
import com.service.posts.migow.migow_posts_service.entities.Post;
import com.service.posts.migow.migow_posts_service.entities.User;

public class PostDTO extends Post {
    private Long reactCount;
    private Long commentCount;
    private Long shareCount;
    
    public PostDTO(UUID id, User owner, Instant createdAt, String text, Set<Media> mediaList, Post sharedPost,
            Long reactCount, Long commentCount, Long shareCount) {
        super(id, owner, createdAt, text, mediaList, sharedPost);
        this.reactCount = reactCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
    }
    public PostDTO(Long reactCount, Long commentCount, Long shareCount) {
        this.reactCount = reactCount;
        this.commentCount = commentCount;
        this.shareCount = shareCount;
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
}
