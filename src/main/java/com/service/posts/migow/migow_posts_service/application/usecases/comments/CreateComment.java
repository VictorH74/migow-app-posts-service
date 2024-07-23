package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.CreateCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateComment implements CreateCommentUseCase {

    private final CommentRepository commentRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public Comment execute(UUID userId, UUID postId, String commentContent) {
        User user = getUserByIdUseCase.execute(userId);

        Comment comment = new Comment();
        comment.setContent(commentContent);
        comment.setOwner(user);
        comment.setPostId(postId);

        return commentRepository.createUpdateComment(comment);
    }

}
