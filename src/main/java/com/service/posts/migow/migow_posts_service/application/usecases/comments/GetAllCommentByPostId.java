package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.comments.CommentResponseDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetReactionCountByTargetIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetReplyCommentCountByCommentIdUseCase;

@Component
public class GetAllCommentByPostId implements GetAllCommentByPostIdUseCase {

    private final CommentRepository commentRepository;
    private final GetReactionCountByTargetIdUseCase getReactionCountByTargetIdUseCase;
    private final GetReplyCommentCountByCommentIdUseCase getReplyCommentCountByCommentIdUseCase;

    public GetAllCommentByPostId(CommentRepository commentRepository, GetReactionCountByTargetIdUseCase getReactionCountByTargetIdUseCase, GetReplyCommentCountByCommentIdUseCase getReplyCommentCountByCommentIdUseCase) {
        this.commentRepository = commentRepository;
        this.getReactionCountByTargetIdUseCase = getReactionCountByTargetIdUseCase;
        this.getReplyCommentCountByCommentIdUseCase = getReplyCommentCountByCommentIdUseCase;
    }

    @Override
    public Page<CommentResponseDTO> execute(UUID postId, Pageable pageable) {
        return commentRepository.getAllCommentByPostId(postId, pageable).map(c -> {
            CommentResponseDTO commentResDTO = new CommentResponseDTO();

            Long reactionCount = getReactionCountByTargetIdUseCase.execute(c.getId(), c.getClass());
            Long replyCommentCount = getReplyCommentCountByCommentIdUseCase.execute(c.getId());

            commentResDTO.setId(c.getId());
            commentResDTO.setOwner(c.getOwner());
            commentResDTO.setPostId(c.getPost().getId());
            commentResDTO.setCreatedAt(c.getCreatedAt());
            commentResDTO.setContent(c.getContent());
            commentResDTO.setReactCount(reactionCount);
            commentResDTO.setReplyCommentCount(replyCommentCount);

            return commentResDTO;
        });
    }

}
