package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.UpdateReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.UpdateReactionByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UpdateReactionById implements UpdateReactionByIdUseCase {
    private final ReactionRepository reactionRepository;

    @Override
    public SimpleReactionDTO execute(UUID id, UpdateReactionDTO obj) {
        Reaction reaction = new Reaction();

        reaction.setId(id);
        reaction.setType(ReactionType.valueOf(obj.getType()).getCode());

        Reaction updatedReaction = reactionRepository.createUpdateReaction(reaction);

        return new SimpleReactionDTO(updatedReaction);
    }

}
