package com.service.posts.migow.migow_posts_service.infra.http.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.CreateCommentUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

@RestController
@RequestMapping("comments")
public class CommentController {

    private final GetAllCommentByPostIdUseCase getAllCommentByPostIdUseCase;
    private final CreateCommentUseCase createCommentUseCase;

    public CommentController(GetAllCommentByPostIdUseCase getAllCommentByPostIdUseCase,
            CreateCommentUseCase createCommentUseCase) {
        this.getAllCommentByPostIdUseCase = getAllCommentByPostIdUseCase;
        this.createCommentUseCase = createCommentUseCase;
    }

    @GetMapping("/{postId}")
    public Page<Comment> getCommentByPostId(
            @PathVariable UUID postId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllCommentByPostIdUseCase.execute(postId, pageable);
    }

    @PostMapping("/{postId}")
    public Comment createPostComment(@PathVariable UUID postId, @RequestBody String content) {
        // TODO: get user from jwt
        User user = new User();
        // user.setId();

        Post post = new Post();
        post.setId(postId);

        Comment comment = new Comment();
        comment.setOwner(user);
        comment.setPost(post);
        comment.setContent(content);

        return createCommentUseCase.execute(comment);
    }

}
