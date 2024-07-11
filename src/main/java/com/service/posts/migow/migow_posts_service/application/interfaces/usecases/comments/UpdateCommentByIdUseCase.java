package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.comments.UpdateCommentDTO;

public interface UpdateCommentByIdUseCase {
    Comment execute(UUID id, UpdateCommentDTO obj);
}
