package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaReplyCommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ReplyCommentRepositoryImpl implements ReplyCommentRepository {

    private final JpaReplyCommentRepository jpaReplyCommentRepository;

    @Override
    public Page<ReplyComment> getAllByCommentId(UUID commentId, DateRangeFilter dateRangeFilter,
            Pageable pageable) {
        return jpaReplyCommentRepository.findAllByCommentId(
                commentId,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public ReplyComment createUpdate(ReplyComment obj) {
        return jpaReplyCommentRepository.save(obj);
    }

    @Override
    public List<ReplyComment> createMany(List<ReplyComment> objs) {
        return jpaReplyCommentRepository.saveAll(objs);
    }

    @Override
    public void deleteById(UUID id) {
        jpaReplyCommentRepository.deleteById(id);

    }

    @Override
    public Long getCountByCommentId(UUID commentId) {
        return jpaReplyCommentRepository.countByCommentId(commentId);
    }

    @Override
    public Optional<ReplyComment> getById(UUID id) {
        return jpaReplyCommentRepository.findById(id);
    }

}
