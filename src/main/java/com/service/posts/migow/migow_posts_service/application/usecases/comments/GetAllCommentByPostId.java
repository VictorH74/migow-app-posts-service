package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.comments.CommentResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.CommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetReplyCommentCountByCommentIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllCommentByPostId implements GetAllCommentByPostIdUseCase {

    private final CommentRepository commentRepository;
    private final GetTargetReactionTypeCountsUseCase getTargetReactionTypeCountsUseCase;
    private final GetReplyCommentCountByCommentIdUseCase getReplyCommentCountByCommentIdUseCase;

    @Override
    public Page<CommentResponseDTO> execute(UUID postId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return commentRepository.getAllCommentByPostId(postId, dateRangeFilter,pageable).map(c -> {
            ReactionTypeCountsDTO reactionTypeCountsDTO = getTargetReactionTypeCountsUseCase.execute(c.getId(),
                    "comment_");

            Long reactionCount = reactionTypeCountsDTO.reactionTotal();
            Long replyCommentCount = getReplyCommentCountByCommentIdUseCase.execute(c.getId());

            CommentResponseDTO commentResDTO = new CommentResponseDTO(c);
            commentResDTO.setReactCount(reactionCount);
            commentResDTO.setReplyCommentCount(replyCommentCount);
            commentResDTO.setReactionTypeCounts(reactionTypeCountsDTO);

            return commentResDTO;
        });
    }

}
