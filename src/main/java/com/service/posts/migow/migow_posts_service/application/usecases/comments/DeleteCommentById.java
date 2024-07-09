package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.DeleteCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.pks.CommentPK;

public class DeleteCommentById implements DeleteCommentByIdUseCase {
    private final CommentRepository commentRepository;

    public DeleteCommentById(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void execute(CommentPK id) {
        commentRepository.deleteCommentById(id);
    }

}
