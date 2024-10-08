package com.service.posts.migow.migow_posts_service.application.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserActivyDTO {

    private UUID ownerId;

    private UUID postId;

    private UUID commentId;

    private UUID replyCommentId;

    private UUID reactionId;
}
