package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments.GetReplyCommentCountByCommentIdUseCase;

@Component
public class GetReplyCommentCountByCommentId implements GetReplyCommentCountByCommentIdUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    public GetReplyCommentCountByCommentId(ReplyCommentRepository replyCommentRepository) {
        this.replyCommentRepository = replyCommentRepository;
    }

    @Override
    public Long execute(UUID commentId) {
        return replyCommentRepository.getReplyCommentCountByCommentId(commentId);
    }

}
