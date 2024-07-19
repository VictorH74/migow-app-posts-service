package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

public interface ReplyCommentRepository {
    Page<ReplyComment> getAllReplyCommentByCommentId(UUID commentId, Pageable pageable);

    Long getReplyCommentCountByCommentId(UUID commentId);

    List<ReplyComment> createManyReplyComment(List<ReplyComment> objs);

    ReplyComment createUpdateReplyComment(ReplyComment obj);

    void deleteReplyCommentById(UUID id);

}
