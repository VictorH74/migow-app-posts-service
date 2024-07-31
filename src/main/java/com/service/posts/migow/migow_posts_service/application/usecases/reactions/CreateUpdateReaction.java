package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateUpdateReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.helpers.validators.ReactionTargetValidator;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.CreateUpdateReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateUpdateReaction implements CreateUpdateReactionUseCase {
    private final ReactionRepository reactionRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public SimpleReactionDTO execute(CreateUpdateReactionDTO obj) {

        if (!ReactionTargetValidator.validateString(obj.getTarget()))
            throw new IllegalArgumentException("Invalid target string format!: " + obj.getTarget());

        User user = getUserByIdUseCase.execute(obj.getOwnerId());

        Reaction reaction = new Reaction();
        reaction.setOwner(user);
        reaction.setType(ReactionType.valueOf(obj.getType()).getCode());
        reaction.setTarget(obj.getTarget());

        reaction.setId(obj.getId() == null ? UUID.randomUUID() : obj.getId());

        Reaction createdReaction = reactionRepository.createUpdateReaction(reaction);

        return new SimpleReactionDTO(createdReaction);
    }

}
