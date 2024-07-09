package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.GetReactionCoundByPostIdUseCase;

public class GetReactionCoundByPostId implements GetReactionCoundByPostIdUseCase {
    private final ReactionRepository reactionRepository;

    public GetReactionCoundByPostId(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Long execute(UUID postId) {
        return reactionRepository.getReactionCoundByPostId(postId);
    }

}
