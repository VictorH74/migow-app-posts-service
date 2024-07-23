package com.service.posts.migow.migow_posts_service.application.dtos.comments;

import java.time.Instant;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.users.SimpleUserDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDTO {
    private UUID id;
    private SimpleUserDTO owner;
    private UUID postId;
    private String content;
    private Instant createdAt;
    private Long reactCount, replyCommentCount;
    private ReactionTypeCountsDTO reactionTypeCounts;

    public CommentResponseDTO(Comment comment) {
        this.id = comment.getId();
        this.owner = new SimpleUserDTO(comment.getOwner());
        this.postId = comment.getPostId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }

    
}
