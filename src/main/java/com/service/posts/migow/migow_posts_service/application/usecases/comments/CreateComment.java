package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.CreateCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

@Component
public class CreateComment implements CreateCommentUseCase {

    private final CommentRepository commentRepository;

    public CreateComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment execute(Comment obj) {
        return commentRepository.createComment(obj);
    }

}
