package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface ReplyCommentRepository {

    Optional<ReplyComment> getById(UUID id);

    Page<ReplyComment> getAllByCommentId(UUID commentId, DateRangeFilter dateRangeFilter, Pageable pageable);

    Long getCountByCommentId(UUID commentId);

    List<ReplyComment> createMany(List<ReplyComment> objs);

    ReplyComment createUpdate(ReplyComment obj);

    void deleteById(UUID id);

}
