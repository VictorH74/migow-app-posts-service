package com.service.posts.migow.migow_posts_service.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.entities.Comment;
import com.service.posts.migow.migow_posts_service.pks.CommentPK;

public interface CommentRepository extends JpaRepository<Comment, CommentPK> {
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.id.post.id = :postId")
    public Long countByPostId(UUID postId);

    @Query("SELECT *(c) FROM Comment c WHERE c.id.post.id = :postId")
    public Page<Comment> findAllCommentByPostId(UUID postId, Pageable pageable);

}
