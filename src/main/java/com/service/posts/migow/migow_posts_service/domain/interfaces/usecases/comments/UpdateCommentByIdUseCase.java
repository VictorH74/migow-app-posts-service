package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.comments.UpdateCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface UpdateCommentByIdUseCase {
    Comment execute(UUID id, UpdateCommentDTO obj);
}
