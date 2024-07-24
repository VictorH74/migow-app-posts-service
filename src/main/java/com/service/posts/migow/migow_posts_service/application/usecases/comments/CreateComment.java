package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.comments.CreateCommentDTO;
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
    public Comment execute(CreateCommentDTO obj) {
        User user = getUserByIdUseCase.execute(obj.getUserId());

        Comment comment = new Comment();
        comment.setContent(obj.getContent());
        comment.setOwner(user);
        comment.setPostId(obj.getPostId());

        return commentRepository.createUpdateComment(comment);
    }

}
