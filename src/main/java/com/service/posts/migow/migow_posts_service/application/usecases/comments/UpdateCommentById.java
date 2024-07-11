package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.UpdateCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.comments.UpdateCommentDTO;

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
