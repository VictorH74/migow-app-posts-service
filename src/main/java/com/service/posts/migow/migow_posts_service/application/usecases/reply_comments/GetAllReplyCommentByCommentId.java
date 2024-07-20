package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetAllReplyCommentByCommentIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllReplyCommentByCommentId implements GetAllReplyCommentByCommentIdUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    @Override
    public Page<ReplyComment> execute(UUID commentId, Pageable pageable) {
        return replyCommentRepository.getAllReplyCommentByCommentId(commentId, pageable);
    }

}
