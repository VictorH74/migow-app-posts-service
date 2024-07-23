package com.service.posts.migow.migow_posts_service.infra.http.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.service.posts.migow.migow_posts_service.domain.exceptions.comment.CommentNotFoundException;

@ControllerAdvice
public class CommentExceptionHandlers {
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<ResponseErrorBody> handlerCommentNotFoundException(CommentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorBody(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }
}
