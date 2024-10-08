package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.comments.CommentResponseDTO;

public interface GetAllCommentByPostIdUseCase {

    Page<CommentResponseDTO> execute(UUID postId, String excludeCommentId, DateRangeFilter dateRangeFilter, Pageable pageable);
}
