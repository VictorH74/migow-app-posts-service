package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.UpdateReplyCommentDTO;

public interface UpdateReplyCommentByIdUseCase {
    SimpleReplyCommentDTO execute(UUID id, UpdateReplyCommentDTO obj);
}
