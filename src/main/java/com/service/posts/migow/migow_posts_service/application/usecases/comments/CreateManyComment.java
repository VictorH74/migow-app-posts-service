package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.CreateManyCommentUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateManyComment implements CreateManyCommentUseCase {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> execute(List<Comment> objs) {
        return commentRepository.createManyComment(objs);
    }

}
