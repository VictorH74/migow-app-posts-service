package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetReactionByIdUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetReactionById implements GetReactionByIdUseCase {

    private final ReactionRepository reactionRepository;

    @Override
    public SimpleReactionDTO execute(UUID id) {
        Optional<Reaction> r = reactionRepository.getById(id);

        // TODO imprement not found exception
        return new SimpleReactionDTO(r.get());
    }

}
