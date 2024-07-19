package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.DeleteReactionByIdUseCase;

@Component
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
