package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments;

import java.util.UUID;

public interface DeleteReplyCommentByIdUseCase {
    void execute(UUID id);
}
