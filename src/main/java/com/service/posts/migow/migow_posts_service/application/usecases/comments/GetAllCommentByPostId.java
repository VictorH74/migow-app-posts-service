package com.service.posts.migow.migow_posts_service.application.usecases.comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.comments.CommentResponseDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;
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
    public Page<CommentResponseDTO> execute(UUID postId, String excludeCommentIdStr, DateRangeFilter dateRangeFilter, Pageable pageable) {
        UUID excludeCommentId;
        try {
            excludeCommentId = UUID.fromString(excludeCommentIdStr);
        } catch (Exception ex) {
            excludeCommentId = UUID.randomUUID();
        }
        return commentRepository.getAllByPostId(postId, excludeCommentId, dateRangeFilter, pageable).map(c -> {
            ReactionCountByTypeDTO reactionCountByTypeDTO = getTargetReactionTypeCountsUseCase.execute(c.getId(),
                    "comment_");

            Long reactionCount = reactionCountByTypeDTO.reactionTotal();
            Long replyCommentCount = getReplyCommentCountByCommentIdUseCase.execute(c.getId());

            CommentResponseDTO commentResDTO = new CommentResponseDTO(c);
            commentResDTO.setReactCount(reactionCount);
            commentResDTO.setReplyCommentCount(replyCommentCount);
            commentResDTO.setReactionCountByType(reactionCountByTypeDTO);

            return commentResDTO;
        });
    }

}
