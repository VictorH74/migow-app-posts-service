package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public class GetAllCommentByPostId implements GetAllCommentByPostIdUseCase {

    private final CommentRepository commentRepository;

    public GetAllCommentByPostId(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<Comment> execute(UUID postId, Pageable pageable) {
        return commentRepository.getAllCommentByPostId(postId, pageable);
    }

}
