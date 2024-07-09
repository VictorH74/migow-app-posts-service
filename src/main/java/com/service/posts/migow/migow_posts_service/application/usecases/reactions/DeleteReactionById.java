package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.DeleteReactionByIdUseCase;

public class DeleteReactionById implements DeleteReactionByIdUseCase {
    private final ReactionRepository reactionRepository;

    public DeleteReactionById(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public void execute(UUID id) {
        reactionRepository.deleteReactionById(id);

    }

}
