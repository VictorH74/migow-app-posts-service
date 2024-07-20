package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateManyReplyCommentUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateManyReplyComment implements CreateManyReplyCommentUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    @Override
    public List<ReplyComment> execute(List<ReplyComment> objs) {
        return replyCommentRepository.createManyReplyComment(objs);
    }

}
