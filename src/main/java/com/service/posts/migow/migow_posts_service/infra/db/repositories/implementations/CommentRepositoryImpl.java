package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaCommentRepository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    private final JpaCommentRepository jpaCommentRepository;

    public CommentRepositoryImpl(JpaCommentRepository jpaCommentRepository) {
        this.jpaCommentRepository = jpaCommentRepository;
    }

    @Override
    public Page<Comment> getAllCommentByPostId(UUID postId, Pageable pageable) {
        return jpaCommentRepository.findAllCommentByPostId(postId, pageable);
    }

    @Override
    public Comment createComment(Comment obj) {
        return jpaCommentRepository.save(obj);
    }

    @Override
    public void deleteCommentById(CommentPK id) {
        jpaCommentRepository.deleteById(id);

    }

    @Override
    public Long getCommentCountByPostId(UUID postId) {
        return jpaCommentRepository.countByPostId(postId);
    }

    @Override
    public Comment updateCommentById(CommentPK id, Comment obj) {
        // TODO Auto-generated method stub
        return null;
    }

}
