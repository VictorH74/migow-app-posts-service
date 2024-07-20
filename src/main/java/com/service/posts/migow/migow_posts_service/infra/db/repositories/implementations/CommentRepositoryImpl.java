package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaCommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class CommentRepositoryImpl implements CommentRepository {
    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public Page<Comment> getAllCommentByPostId(UUID postId, Pageable pageable) {
        return jpaCommentRepository.findAllCommentByPostId(postId, pageable);
    }

    @Override
    public List<Comment> createManyComment(List<Comment> objs) {
        return jpaCommentRepository.saveAll(objs);
    }

    @Override
    public Comment createUpdateComment(Comment obj) {
        return jpaCommentRepository.save(obj);
    }

    @Override
    public void deleteCommentById(UUID id) {
        jpaCommentRepository.deleteById(id);

    }

    @Override
    public Long getCommentCountByPostId(UUID postId) {
        return jpaCommentRepository.countByPostId(postId);
    }

}
