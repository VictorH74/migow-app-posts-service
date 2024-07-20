package com.service.posts.migow.migow_posts_service.application.dtos.comments;

import java.time.Instant;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDTO {
    private UUID id;
    private User owner;
    private UUID postId;
    private String content;
    private Instant createdAt;
    private Long reactCount;
    private Long replyCommentCount;
}
