package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.DeleteReplyCommentByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteReplyCommentById implements DeleteReplyCommentByIdUseCase {
    private final ReplyCommentRepository commentRepository;

    @Override
    public void execute(UUID id) {
        commentRepository.deleteReplyCommentById(id);
    }

}
