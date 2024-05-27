package com.service.posts.migow.migow_posts_service.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.entities.Comment;
import com.service.posts.migow.migow_posts_service.services.CommentService;


@RestController("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public Page<Comment> getCommentByPostId(
        @RequestParam(name="pageNumber") UUID postId,
        @RequestParam(name="pageNumber", defaultValue = "0") int pageNumber,
        @RequestParam(name="pageNumber", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return commentService.findAllCommentByPostId(postId, pageable);
    }
    

}
