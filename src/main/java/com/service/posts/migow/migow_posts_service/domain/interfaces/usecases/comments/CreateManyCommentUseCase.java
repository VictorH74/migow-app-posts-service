package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface CreateManyCommentUseCase {
    List<Comment> execute(List<Comment> objs);
}
