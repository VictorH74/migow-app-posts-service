package com.service.posts.migow.migow_posts_service.application.dtos.reply_comments;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateReplyCommentRequestDTO {
    private UUID ownerId;
    private UUID commentId;
    private String content;
}
