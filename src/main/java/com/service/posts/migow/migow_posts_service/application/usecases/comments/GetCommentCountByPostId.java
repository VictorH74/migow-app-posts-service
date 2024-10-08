package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetCommentCountByPostId implements GetCommentCountByPostIdUseCase {

    private final CommentRepository commentRepository;

    @Override
    public Long execute(UUID postId) {
        return commentRepository.getCountByPostId(postId);
    }

}
