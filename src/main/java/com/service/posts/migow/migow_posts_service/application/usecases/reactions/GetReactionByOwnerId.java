package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetReactionByOwnerIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetReactionByOwnerId implements GetReactionByOwnerIdUseCase {
    private final ReactionRepository reactionRepository;

    @Override
    public Optional<Reaction> execute(UUID ownerId, String target) {
        return reactionRepository.getReactionByOwnerId(ownerId, target);
    }

}
