package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;

public interface GetAllCommentReplyUseCase {
    Page<SimpleReplyCommentDTO> execute(UUID commentId, DateRangeFilter dateRangeFilter, Pageable pageable);
}
