package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.CreateReplyCommentRequestDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.UpdateReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateReplyCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.DeleteReplyCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetAllCommentReplyUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.UpdateReplyCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.infra.helpers.SecurityUtils;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("reply-comments")
@AllArgsConstructor
public class ReplyCommentController {

    private final GetAllCommentReplyUseCase getAllReplyCommentByCommentIdUseCase;
    private final CreateReplyCommentUseCase createReplyCommentUseCase;
    private final UpdateReplyCommentByIdUseCase updateReplyCommentByIdUseCase;
    private final DeleteReplyCommentByIdUseCase deleteReplyCommentByIdUseCase;

    @GetMapping("/{commentId}")
    public Page<SimpleReplyCommentDTO> getReplyCommentByCommentId(
            @PathVariable UUID commentId,
            @RequestParam(name = "startDate", defaultValue = "") String startDate,
            @RequestParam(name = "endDate", defaultValue = "") String endDate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        DateRangeFilter dateRangeFilter = DateRangeFilter.of(startDate, endDate);
        return getAllReplyCommentByCommentIdUseCase.execute(commentId, dateRangeFilter, pageable);
    }

    @PostMapping
    public SimpleReplyCommentDTO createPostReplyComment(@RequestBody CreateReplyCommentRequestDTO obj) {
        UUID userId = SecurityUtils.getAuthenticatedUserId();
        obj.setOwnerId(userId);
        
        // TODO: provide created entity to kafka
        return createReplyCommentUseCase.execute(obj);
    }

    @PatchMapping("/{replyCommentId}")
    public SimpleReplyCommentDTO updateReplyComment(@PathVariable UUID replyCommentId, @RequestBody UpdateReplyCommentDTO obj) {
        // TODO: provide created entity to kafka
        return updateReplyCommentByIdUseCase.execute(replyCommentId, obj);
    }

    @DeleteMapping("/{replyCommentId}")
    public ResponseEntity<String> deleteReplyComment(@PathVariable UUID replyCommentId) {
        deleteReplyCommentByIdUseCase.execute(replyCommentId);
        // TODO: provide created entity to kafka
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Reply comment with id '$s' deleted!", replyCommentId));
    }

}
