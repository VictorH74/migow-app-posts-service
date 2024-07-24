package com.service.posts.migow.migow_posts_service.application.dtos.comments;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateCommentDTO {
    private UUID postId;
    private UUID userId;
    private String content;
}
