package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.enums.ReactionType;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.GetCountByReactionTypeUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetCountByReactionType implements GetCountByReactionTypeUseCase {
    private final ReactionRepository repository;

    @Override
    public Long execute(String target, int reactionTypeCode) {
        return repository.getCountByReactionType(target, ReactionType.valueOf(reactionTypeCode).getCode());
    }

}
