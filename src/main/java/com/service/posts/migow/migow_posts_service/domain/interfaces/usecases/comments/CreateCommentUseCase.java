package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface CreateCommentUseCase {
    Comment execute(UUID userId, UUID postId, String commentContent);
}
