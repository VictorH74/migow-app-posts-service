package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetReplyCommentCountByCommentIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetReplyCommentCountByCommentId implements GetReplyCommentCountByCommentIdUseCase {

    private final ReplyCommentRepository replyCommentRepository;

    @Override
    public Long execute(UUID commentId) {
        return replyCommentRepository.getCountByCommentId(commentId);
    }

}
