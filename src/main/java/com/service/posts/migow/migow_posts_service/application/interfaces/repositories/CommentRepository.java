package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;

public interface CommentRepository {
    Page<Comment> getAllCommentByPostId(UUID postId, Pageable pageable);

    Long getCommentCountByPostId(UUID postId);

    Comment createComment(Comment obj);

    void deleteCommentById(CommentPK id);

    Comment updateCommentById(CommentPK id, Comment obj);

}
