package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetAllReplyCommentByCommentIdUseCase;

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
