package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.CreateReplyCommentRequestDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;

public interface CreateReplyCommentUseCase {
    SimpleReplyCommentDTO execute(CreateReplyCommentRequestDTO obj);
}
