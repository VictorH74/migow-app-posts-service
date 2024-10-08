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
import com.service.posts.migow.migow_posts_service.application.dtos.comments.CommentResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.comments.CreateCommentDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.comments.UpdateCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.CreateCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.DeleteCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.UpdateCommentByIdUseCase;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("comments")
@AllArgsConstructor
@Log4j2
public class CommentController {

    private final GetAllCommentByPostIdUseCase getAllCommentByPostIdUseCase;
    private final CreateCommentUseCase createCommentUseCase;
    private final UpdateCommentByIdUseCase updateCommentByIdUseCase;
    private final DeleteCommentByIdUseCase deleteCommentByIdUseCase;
    private final GetCommentByIdUseCase getCommentByIdUseCase;

    @GetMapping("/{postId}")
    public Page<CommentResponseDTO> getAllPostComment(
            @PathVariable UUID postId,
            @RequestParam(name = "excludeCommentId", defaultValue = "") String excludeCommentId,
            @RequestParam(name = "startDate", defaultValue = "") String startDate,
            @RequestParam(name = "endDate", defaultValue = "") String endDate,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        DateRangeFilter dateRangeFilter = DateRangeFilter.of(startDate, endDate);
        log.info(postId);
        log.info(excludeCommentId);
        return getAllCommentByPostIdUseCase.execute(postId, excludeCommentId, dateRangeFilter, pageable);
    }

    @PostMapping
    public Comment createPostComment(@RequestBody CreateCommentDTO obj,
            HttpServletRequest request) {
        UUID userId = UUID.fromString(request.getHeader("userId"));

        obj.setUserId(userId);

        return createCommentUseCase.execute(obj);
    }

    @GetMapping("/unique/{commentId}")
    public Comment getUniqueComment(@PathVariable UUID commentId) {
        return getCommentByIdUseCase.execute(commentId);
    }

    @PatchMapping("/{commentId}")
    public Comment updatePostComment(@PathVariable UUID commentId, @RequestBody UpdateCommentDTO obj) {

        return updateCommentByIdUseCase.execute(commentId, obj);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable UUID commentId) {
        deleteCommentByIdUseCase.execute(commentId);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Comment with id '$s' deleted!", commentId));
    }

}
