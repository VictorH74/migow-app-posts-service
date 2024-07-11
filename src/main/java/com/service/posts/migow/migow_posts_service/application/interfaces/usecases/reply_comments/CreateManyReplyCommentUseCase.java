package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reply_comments;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface CreateManyReplyCommentUseCase {
    List<ReplyComment> execute(List<ReplyComment> objs);
}
