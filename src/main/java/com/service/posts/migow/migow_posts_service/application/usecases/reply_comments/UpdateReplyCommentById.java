package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments.UpdateReplyCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.reply_comments.UpdateReplyCommentDTO;

@Component
public class UpdateReplyCommentById implements UpdateReplyCommentByIdUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    public UpdateReplyCommentById(ReplyCommentRepository replyCommentRepository) {
        this.replyCommentRepository = replyCommentRepository;
    }

    @Override
    public ReplyComment execute(UUID id, UpdateReplyCommentDTO obj) {
        ReplyComment replyComment = new ReplyComment();
        replyComment.setId(id);

        if (!obj.getContent().isBlank())
            replyComment.setContent(obj.getContent());

        return replyCommentRepository.createUpdateReplyComment(replyComment);
    }

}
