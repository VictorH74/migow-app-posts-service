package com.service.posts.migow.migow_posts_service.domain.exceptions.comment;

public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException(String message) {
        super(message);
    }

    public CommentNotFoundException() {
        super("Comment not found!");
    }
}
