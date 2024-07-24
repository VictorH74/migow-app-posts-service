package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface JpaReplyCommentRepository extends JpaRepository<ReplyComment, UUID> {
    @Query("SELECT COUNT(c) FROM ReplyComment c WHERE c.comment.id = :commentId")
    public Long countByCommentId(UUID commentId);

    @Query("SELECT c FROM ReplyComment c WHERE c.comment.id = :commentId AND c.createdAt BETWEEN :startDate AND :endDate ORDER BY c.createdAt DESC")
    public Page<ReplyComment> findAllReplyCommentByCommentId(UUID commentId, Instant startDate, Instant endDate, Pageable pageable);

}
