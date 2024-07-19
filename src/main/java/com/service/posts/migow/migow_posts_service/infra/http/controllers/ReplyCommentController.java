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

import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.CreateReplyCommentRequestDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateReplyCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetAllReplyCommentByCommentIdUseCase;

@RestController
@RequestMapping("reply-comments")
public class ReplyCommentController {

    private final GetAllReplyCommentByCommentIdUseCase getAllReplyCommentByCommentIdUseCase;
    private final CreateReplyCommentUseCase createReplyCommentUseCase;

    public ReplyCommentController(GetAllReplyCommentByCommentIdUseCase getAllReplyCommentByCommentIdUseCase,
            CreateReplyCommentUseCase createReplyCommentUseCase) {
        this.getAllReplyCommentByCommentIdUseCase = getAllReplyCommentByCommentIdUseCase;
        this.createReplyCommentUseCase = createReplyCommentUseCase;
    }

    @GetMapping("/{commentId}")
    public Page<ReplyComment> getReplyCommentByCommentId(
            @PathVariable UUID commentId,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return getAllReplyCommentByCommentIdUseCase.execute(commentId, pageable);
    }

    @PostMapping("/{commentId}")
    public ReplyComment createPostReplyComment(@PathVariable UUID commentId,
            @RequestBody CreateReplyCommentRequestDTO obj) {
        // TODO: get user from jwt
        User user = new User();
        // user.setId();

        Comment comment = new Comment();
        comment.setId(commentId);

        ReplyComment replyComment = new ReplyComment();
        replyComment.setOwner(user);
        replyComment.setComment(comment);
        replyComment.setContent(obj.getContent());

        return createReplyCommentUseCase.execute(replyComment);
    }

}
