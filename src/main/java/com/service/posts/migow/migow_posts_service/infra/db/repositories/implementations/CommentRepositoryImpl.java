package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaCommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public Page<Comment> getAllByPostId(UUID postId, UUID excludeCommentId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return jpaCommentRepository.findAllByPostId(
                postId,
                excludeCommentId,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Optional<Comment> getById(UUID id) {
        return jpaCommentRepository.findById(id);
    }

    @Override
    public List<Comment> createMany(List<Comment> objs) {
        return jpaCommentRepository.saveAll(objs);
    }

    @Override
    public Comment createUpdate(Comment obj) {
        return jpaCommentRepository.save(obj);
    }

    @Override
    public void deleteById(UUID id) {
        jpaCommentRepository.deleteById(id);

    }

    @Override
    public Long getCountByPostId(UUID postId) {
        return jpaCommentRepository.countByPostId(postId);
    }

}
