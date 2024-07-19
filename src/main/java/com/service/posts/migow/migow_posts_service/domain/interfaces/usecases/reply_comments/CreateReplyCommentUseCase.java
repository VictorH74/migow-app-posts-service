package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface CreateReplyCommentUseCase {
    ReplyComment execute(ReplyComment obj);
}
