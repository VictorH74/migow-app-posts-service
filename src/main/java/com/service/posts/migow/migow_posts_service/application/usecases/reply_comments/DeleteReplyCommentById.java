package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments.DeleteReplyCommentByIdUseCase;

@Component
public class DeleteReplyCommentById implements DeleteReplyCommentByIdUseCase {
    private final ReplyCommentRepository commentRepository;

    public DeleteReplyCommentById(ReplyCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void execute(UUID id) {
        commentRepository.deleteReplyCommentById(id);
    }

}
