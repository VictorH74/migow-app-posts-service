package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetReplyCommentByIdUseCase;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetReplyCommentById implements GetReplyCommentByIdUseCase {

    private final ReplyCommentRepository commentRepository;

    @Override
    public ReplyComment execute(UUID id) {
        Optional<ReplyComment> rComment = commentRepository.getById(id);

        // TODO: impl not found error
        return rComment.get();
    }

}
