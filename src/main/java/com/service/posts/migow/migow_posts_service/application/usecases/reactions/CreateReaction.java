package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.helpers.validators.ReactionTargetValidator;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.CreateReactionUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateReaction implements CreateReactionUseCase {
    private final ReactionRepository reactionRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    @Override
    public SimpleReactionDTO execute(CreateReactionDTO obj) {
        User user = getUserByIdUseCase.execute(obj.getOwnerId());

        Reaction reaction = new Reaction();
        reaction.setOwner(user);
        reaction.setType(ReactionType.valueOf(obj.getType()).getCode());
        reaction.setTarget(ReactionTargetValidator.generateTarget(obj.getTargetId(), obj.getTargetClass()));

        Reaction createdReaction = reactionRepository.createUpdateReaction(reaction);

        return new SimpleReactionDTO(createdReaction);
    }

}
