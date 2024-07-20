package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaReplyCommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ReplyCommentRepositoryImpl implements ReplyCommentRepository {
    private final JpaReplyCommentRepository jpaReplyCommentRepository;

    @Override
    public Page<ReplyComment> getAllReplyCommentByCommentId(UUID commentId, Pageable pageable) {
        return jpaReplyCommentRepository.findAllReplyCommentByCommentId(commentId, pageable);
    }

    @Override
    public ReplyComment createUpdateReplyComment(ReplyComment obj) {
        return jpaReplyCommentRepository.save(obj);
    }

    @Override
    public List<ReplyComment> createManyReplyComment(List<ReplyComment> objs) {
        return jpaReplyCommentRepository.saveAll(objs);
    }

    @Override
    public void deleteReplyCommentById(UUID id) {
        jpaReplyCommentRepository.deleteById(id);

    }

    @Override
    public Long getReplyCommentCountByCommentId(UUID commentId) {
        return jpaReplyCommentRepository.countByCommentId(commentId);
    }

}
