package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;

@RestController("/comments")
public class CommentController {

    private final GetAllCommentByPostIdUseCase getAllCommentByPostIdUseCase;

    public CommentController(GetAllCommentByPostIdUseCase getAllCommentByPostIdUseCase) {
        this.getAllCommentByPostIdUseCase = getAllCommentByPostIdUseCase;
    }

    @GetMapping("/comments")
    public Page<Comment> getCommentByPostId(
            @RequestParam(name = "pageNumber") UUID postId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageNumber", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllCommentByPostIdUseCase.execute(postId, pageable);
    }

}
