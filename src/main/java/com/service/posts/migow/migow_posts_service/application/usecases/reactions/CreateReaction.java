package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Comment;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.entities.ReplyComment;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.CreateReactionUseCase;

@Component
public class CreateReaction implements CreateReactionUseCase {
    private final ReactionRepository reactionRepository;

    public CreateReaction(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Reaction execute(CreateReactionDTO obj, UUID targetId, Class<?> targetClass) {

        Reaction reaction = new Reaction();

        reaction.setOwner(obj.getOwner());
        // TODO: implement http exception
        reaction.setType(ReactionType.valueOf(obj.getType()).getCode());

        if (targetClass == Post.class) {
            reaction.setTarget("post_" + targetId);
        } else if (targetClass == Comment.class) {
            reaction.setTarget("comment_" + targetId);
        } else if (targetClass == ReplyComment.class) {
            reaction.setTarget("reply_comment_" + targetId);
        } else {
            // TODO: implement http exception
            throw new IllegalArgumentException("Invalid target class!");
        }

        return reactionRepository.createUpdateReaction(reaction);
    }

}
