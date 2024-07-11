package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments.GetAllReplyCommentByCommentIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

@Component
public class GetAllReplyCommentByCommentId implements GetAllReplyCommentByCommentIdUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    public GetAllReplyCommentByCommentId(ReplyCommentRepository replyCommentRepository) {
        this.replyCommentRepository = replyCommentRepository;
    }

    @Override
    public Page<ReplyComment> execute(UUID commentId, Pageable pageable) {
        return replyCommentRepository.getAllReplyCommentByCommentId(commentId, pageable);
    }

}
