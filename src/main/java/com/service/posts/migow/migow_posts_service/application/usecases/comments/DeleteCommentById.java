package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.DeleteCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.DeleteAllReactionByTargetUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteCommentById implements DeleteCommentByIdUseCase {

    private final CommentRepository commentRepository;
    private final DeleteAllReactionByTargetUseCase deleteAllReactionByTargetUseCase;

    @Override
    public void execute(UUID id) {
        commentRepository.deleteById(id);
        deleteAllReactionByTargetUseCase.execute("comment_" + id);

        // TODO: provide deleted entity to kafka
    }

}
