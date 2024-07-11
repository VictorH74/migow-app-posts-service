package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.GetReactionCountByTargetIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;

@Component
public class GetReactionCountByTargetId implements GetReactionCountByTargetIdUseCase {
    private final ReactionRepository reactionRepository;

    public GetReactionCountByTargetId(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Long execute(UUID targetId, Class<?> targetClass) {

        String target;

        if (targetClass == Post.class) {
            target = "post_" + targetId;
        } else if (targetClass == Comment.class) {
            target = "comment_" + targetId;
        } else if (targetClass == ReplyComment.class) {
            target = "reply_comment_" + targetId;
        } else {
            // TODO: implement http exception
            throw new IllegalArgumentException("Invalid target class!");
        }

        return reactionRepository.getReactionCountByTarget(target);

    }

}
