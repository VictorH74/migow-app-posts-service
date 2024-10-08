package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.DeleteReactionByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteReactionById implements DeleteReactionByIdUseCase {

    private final ReactionRepository reactionRepository;

    @Override
    public void execute(UUID id) {
        reactionRepository.deleteById(id);

        // TODO: provide deleted entity to kafka
    }

}
