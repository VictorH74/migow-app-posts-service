package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

public interface JpaCommentRepository extends JpaRepository<Comment, UUID> {
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.postId = :postId")
    public Long countByPostId(UUID postId);

    @Query("SELECT c FROM Comment c WHERE c.postId = :postId AND c.createdAt BETWEEN :startDate AND :endDate")
    public Page<Comment> findAllCommentByPostId(UUID postId, Instant startDate, Instant endDate, Pageable pageable);

}
