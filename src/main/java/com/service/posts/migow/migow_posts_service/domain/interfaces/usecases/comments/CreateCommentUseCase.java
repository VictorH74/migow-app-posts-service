package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import com.service.posts.migow.migow_posts_service.application.dtos.comments.CreateCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface CreateCommentUseCase {
    Comment execute(CreateCommentDTO obj);
}
