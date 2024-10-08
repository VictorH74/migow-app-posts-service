package com.service.posts.migow.migow_posts_service.application.usecases.reply_comments;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reply_comments.SimpleReplyCommentDTO;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReplyCommentRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reply_comments.GetAllCommentReplyUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetAllCommentReply implements GetAllCommentReplyUseCase {

    private final ReplyCommentRepository replyCommentRepository;
    private final GetTargetReactionTypeCountsUseCase getTargetReactionTypeCountsUseCase;

    @Override
    public Page<SimpleReplyCommentDTO> execute(UUID commentId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return replyCommentRepository.getAllByCommentId(commentId, dateRangeFilter, pageable).map(rc -> {
            SimpleReplyCommentDTO simpleReplyCommentDTO = new SimpleReplyCommentDTO(rc);
            ReactionCountByTypeDTO reactionCountByTypeDTO = getTargetReactionTypeCountsUseCase.execute(rc.getId(), "reply_comment_");

            Long reactionCount = reactionCountByTypeDTO.reactionTotal();

            simpleReplyCommentDTO.setReactCount(reactionCount);
            simpleReplyCommentDTO.setReactionCountByType(reactionCountByTypeDTO);

            return simpleReplyCommentDTO;
        });
    }

}
