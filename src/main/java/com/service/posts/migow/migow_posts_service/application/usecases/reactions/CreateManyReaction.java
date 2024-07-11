package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.CreateManyReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

@Component
public class CreateManyReaction implements CreateManyReactionUseCase {
    private final ReactionRepository reactionRepository;

    public CreateManyReaction(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public List<Reaction> execute(List<Reaction> objs) {
        return reactionRepository.createManyReaction(objs);
    }
}
