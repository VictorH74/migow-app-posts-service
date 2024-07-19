package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface GetAllReplyCommentByCommentIdUseCase {
    Page<ReplyComment> execute(UUID commentId, Pageable pageable);
}
