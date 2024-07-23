package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface CommentRepository {
    Page<Comment> getAllCommentByPostId(UUID postId, DateRangeFilter dateRangeFilter, Pageable pageable);

    List<Comment> createManyComment(List<Comment> objs);

    Comment createUpdateComment(Comment obj);

    Optional<Comment> getCommentById(UUID id);

    Long getCommentCountByPostId(UUID postId);

    void deleteCommentById(UUID id);
}
