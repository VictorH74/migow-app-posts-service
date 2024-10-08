package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface CommentRepository {

    Page<Comment> getAllByPostId(UUID postId, UUID excludeCommentId, DateRangeFilter dateRangeFilter, Pageable pageable);

    List<Comment> createMany(List<Comment> objs);

    Comment createUpdate(Comment obj);

    Optional<Comment> getById(UUID id);

    Long getCountByPostId(UUID postId);

    void deleteById(UUID id);
}
