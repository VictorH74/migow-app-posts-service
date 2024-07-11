package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.UpdateReactionByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.reactions.UpdateReactionDTO;

@Component
public class UpdateReactionById implements UpdateReactionByIdUseCase {
    private final ReactionRepository reactionRepository;

    public UpdateReactionById(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Reaction execute(UUID id, UpdateReactionDTO obj) {
        Reaction reaction = new Reaction();

        reaction.setId(id);

        // TODO: implement http exception
        reaction.setType(ReactionType.valueOf(obj.getType()).getCode());

        return reactionRepository.createUpdateReaction(reaction);
    }

}
