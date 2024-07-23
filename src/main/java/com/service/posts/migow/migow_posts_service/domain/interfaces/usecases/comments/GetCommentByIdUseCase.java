package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface GetCommentByIdUseCase {
    public Comment execute(UUID id);
}
