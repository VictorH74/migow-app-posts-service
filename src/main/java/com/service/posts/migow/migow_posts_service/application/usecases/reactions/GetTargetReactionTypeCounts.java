package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;
import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.helpers.validators.ReactionTargetValidator;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetTargetReactionTypeCountsUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetTargetReactionTypeCounts implements GetTargetReactionTypeCountsUseCase {
    private final ReactionRepository reactionRepository;

    @Override
    public ReactionTypeCountsDTO execute(UUID targetId, String targetClass) {
        ReactionTypeCountsDTO reactionTypeCountsDTO = new ReactionTypeCountsDTO();

        String target = ReactionTargetValidator.generateTarget(targetId, targetClass);

        Long likeReaction = reactionRepository.getCountByReactionType(target, ReactionType.LIKE.getCode());
        Long funnyReaction = reactionRepository.getCountByReactionType(target, ReactionType.FUNNY.getCode());
        Long loveReaction = reactionRepository.getCountByReactionType(target, ReactionType.LOVE.getCode());
        Long sadReaction = reactionRepository.getCountByReactionType(target, ReactionType.SAD.getCode());
        Long cuteReaction = reactionRepository.getCountByReactionType(target, ReactionType.CUTE.getCode());
        Long scaryReaction = reactionRepository.getCountByReactionType(target, ReactionType.SCARY.getCode());

        reactionTypeCountsDTO.setLikeReaction(likeReaction);
        reactionTypeCountsDTO.setFunnyReaction(funnyReaction);
        reactionTypeCountsDTO.setLoveReaction(loveReaction);
        reactionTypeCountsDTO.setSadReaction(sadReaction);
        reactionTypeCountsDTO.setCuteReaction(cuteReaction);
        reactionTypeCountsDTO.setScaryReaction(scaryReaction);

        return reactionTypeCountsDTO;

    }

}
