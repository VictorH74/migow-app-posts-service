package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.CreateCommentUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateComment implements CreateCommentUseCase {

    private final CommentRepository commentRepository;

    @Override
    public Comment execute(Comment obj) {
        return commentRepository.createUpdateComment(obj);
    }

}
