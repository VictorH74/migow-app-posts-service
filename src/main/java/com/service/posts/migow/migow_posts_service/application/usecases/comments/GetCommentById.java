package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.exceptions.comment.CommentNotFoundException;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetCommentById implements GetCommentByIdUseCase {

    private final CommentRepository commentRepository;

    @Override
    public Comment execute(UUID id) {
        return commentRepository.getById(id)
                .orElseThrow(() -> new CommentNotFoundException(String.format("Comment with id '%s' not found!", id)));
    }

}
