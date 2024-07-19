package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateReplyCommentUseCase;

@Component
public class CreateReplyComment implements CreateReplyCommentUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    public CreateReplyComment(ReplyCommentRepository replyCommentRepository) {
        this.replyCommentRepository = replyCommentRepository;
    }

    @Override
    public ReplyComment execute(ReplyComment obj) {
        return replyCommentRepository.createUpdateReplyComment(obj);
    }

}
