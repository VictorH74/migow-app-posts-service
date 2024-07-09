package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.CreateReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

@Component
public class CreateReaction implements CreateReactionUseCase {
    private final ReactionRepository reactionRepository;

    public CreateReaction(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Reaction execute(Reaction obj) {
        return reactionRepository.createReaction(obj);
    }

}
