package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.reply_comments.UpdateReplyCommentDTO;

public interface UpdateReplyCommentByIdUseCase {
    ReplyComment execute(UUID id, UpdateReplyCommentDTO obj);
}
