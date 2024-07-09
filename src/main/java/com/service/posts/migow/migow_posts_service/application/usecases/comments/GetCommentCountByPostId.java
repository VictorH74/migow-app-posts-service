package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;

public class GetCommentCountByPostId implements GetCommentCountByPostIdUseCase {

    private final CommentRepository commentRepository;

    public GetCommentCountByPostId(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Long execute(UUID postId) {
        return commentRepository.getCommentCountByPostId(postId);
    }

}
