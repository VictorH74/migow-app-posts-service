package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface CreateCommentUseCase {
    Comment execute(Comment obj);
}
