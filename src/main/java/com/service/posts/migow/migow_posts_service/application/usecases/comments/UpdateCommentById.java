package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.comments.UpdateCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.UpdateCommentByIdUseCase;

@Component
public class UpdateCommentById implements UpdateCommentByIdUseCase {

    private final CommentRepository commentRepository;

    public UpdateCommentById(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment execute(UUID id, UpdateCommentDTO obj) {
        Comment comment = new Comment();
        comment.setId(id);

        if (!obj.getContent().isBlank())
            comment.setContent(obj.getContent());

        return commentRepository.createUpdateComment(comment);
    }

}
