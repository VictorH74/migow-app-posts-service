package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.UpdateReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.UpdateReplyCommentByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UpdateReplyCommentById implements UpdateReplyCommentByIdUseCase {
    private final ReplyCommentRepository replyCommentRepository;

    @Override
    public SimpleReplyCommentDTO execute(UUID id, UpdateReplyCommentDTO obj) {
        ReplyComment replyComment = new ReplyComment();
        replyComment.setId(id);

        if (!obj.getContent().isBlank())
            replyComment.setContent(obj.getContent());

        ReplyComment updatedReplyComment = replyCommentRepository.createUpdateReplyComment(replyComment);

        return new SimpleReplyCommentDTO(updatedReplyComment);
    }

}
