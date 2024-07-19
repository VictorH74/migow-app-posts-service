package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import java.util.UUID;

public interface GetReplyCommentCountByCommentIdUseCase {
    Long execute(UUID commentId);
}
