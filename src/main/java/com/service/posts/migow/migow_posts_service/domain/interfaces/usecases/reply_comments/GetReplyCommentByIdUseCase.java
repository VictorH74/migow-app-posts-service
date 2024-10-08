package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface GetReplyCommentByIdUseCase {

    ReplyComment execute(UUID id);
}
