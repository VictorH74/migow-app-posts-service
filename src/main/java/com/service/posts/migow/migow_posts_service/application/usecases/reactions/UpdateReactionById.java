package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.UpdateReactionByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public class UpdateReactionById implements UpdateReactionByIdUseCase {
    private final ReactionRepository reactionRepository;

    public UpdateReactionById(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Reaction execute(UUID id, Reaction obj) {
        return reactionRepository.updateReaction(id, obj);
    }

}
