package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionTypeCountsDTO;

public interface GetTargetReactionTypeCountsUseCase {
    ReactionTypeCountsDTO execute(UUID targetId, String targetClass);
}
