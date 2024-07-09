package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.UpdateCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;

@Component
public class UpdateCommentById implements UpdateCommentByIdUseCase {

    private final CommentRepository commentRepository;

    public UpdateCommentById(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment execute(CommentPK id, Comment obj) {
        return commentRepository.updateCommentById(id, obj);
    }

}
