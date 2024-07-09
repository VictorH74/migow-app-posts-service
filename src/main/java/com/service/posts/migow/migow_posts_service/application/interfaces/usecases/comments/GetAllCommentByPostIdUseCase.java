package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface GetAllCommentByPostIdUseCase {
    Page<Comment> execute(UUID postId, Pageable pageable);
}
