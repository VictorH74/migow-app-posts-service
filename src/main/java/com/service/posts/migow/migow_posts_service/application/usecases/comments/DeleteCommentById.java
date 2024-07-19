package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.DeleteCommentByIdUseCase;

@Component
public class DeleteCommentById implements DeleteCommentByIdUseCase {
    private final CommentRepository commentRepository;

    public DeleteCommentById(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void execute(UUID id) {
        commentRepository.deleteCommentById(id);
    }

}
