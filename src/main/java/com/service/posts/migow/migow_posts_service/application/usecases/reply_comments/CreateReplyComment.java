package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.CreateReplyCommentRequestDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.CreateReplyCommentUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateReplyComment implements CreateReplyCommentUseCase {
    private final ReplyCommentRepository replyCommentRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetCommentByIdUseCase getCommentByIdUseCase;

    @Override
    public SimpleReplyCommentDTO execute(CreateReplyCommentRequestDTO obj) {
        Comment comment = getCommentByIdUseCase.execute(obj.getCommentId());

        User user = getUserByIdUseCase.execute(obj.getOwnerId());

        ReplyComment replyComment = new ReplyComment();
        replyComment.setOwner(user);
        replyComment.setComment(comment);
        replyComment.setContent(obj.getContent());

        ReplyComment createdReplyComment = replyCommentRepository.createUpdateReplyComment(replyComment);

        return new SimpleReplyCommentDTO(createdReplyComment);
    }

}
