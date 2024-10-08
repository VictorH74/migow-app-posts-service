package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;
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
    public ReactionCountByTypeDTO execute(UUID targetId, String targetClass) {
        ReactionCountByTypeDTO reactionCountByTypeDTO = new ReactionCountByTypeDTO();

        String target = ReactionTargetValidator.generateTarget(targetId, targetClass);

        Long likeReaction = reactionRepository.getCountByReactionType(target, ReactionType.LIKE.getCode());
        Long funnyReaction = reactionRepository.getCountByReactionType(target, ReactionType.FUNNY.getCode());
        Long loveReaction = reactionRepository.getCountByReactionType(target, ReactionType.LOVE.getCode());
        Long sadReaction = reactionRepository.getCountByReactionType(target, ReactionType.SAD.getCode());
        Long cuteReaction = reactionRepository.getCountByReactionType(target, ReactionType.CUTE.getCode());
        Long scaryReaction = reactionRepository.getCountByReactionType(target, ReactionType.SCARY.getCode());

        reactionCountByTypeDTO.setLikeReaction(likeReaction);
        reactionCountByTypeDTO.setFunnyReaction(funnyReaction);
        reactionCountByTypeDTO.setLoveReaction(loveReaction);
        reactionCountByTypeDTO.setSadReaction(sadReaction);
        reactionCountByTypeDTO.setCuteReaction(cuteReaction);
        reactionCountByTypeDTO.setScaryReaction(scaryReaction);

        return reactionCountByTypeDTO;

    }

}
