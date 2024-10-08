package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.DeleteAllReactionByTargetUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.DeleteReplyCommentByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteReplyCommentById implements DeleteReplyCommentByIdUseCase {

    private final ReplyCommentRepository commentRepository;
    private final DeleteAllReactionByTargetUseCase deleteAllReactionByTargetUseCase;

    @Override
    public void execute(UUID id) {
        commentRepository.deleteById(id);
        deleteAllReactionByTargetUseCase.execute("reply_comment_" + id);

        // TODO: provide deleted entity to kafka
    }

}
