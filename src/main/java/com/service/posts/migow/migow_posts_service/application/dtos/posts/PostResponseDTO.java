package com.service.posts.migow.migow_posts_service.application.dtos.posts;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Media;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDTO implements Serializable {
    private UUID id;
    private User owner;
    private Instant createdAt;
    private String text;
    private Set<Media> mediaList;
    private Post sharedPost;
    private Long reactCount, commentCount, shareCount;
    private ReactionTypeCountsDTO reactionTypeCounts;
    private SimpleReactionDTO currentUserReaction;

    public PostResponseDTO(Post post,
            Long reactCount, Long commentCount, Long shareCount) {
        this.id = post.getId();
        this.owner = post.getOwner();
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
}
