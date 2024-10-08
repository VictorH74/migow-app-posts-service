package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.ReactionCountByTypeDTO;

public interface GetTargetReactionTypeCountsUseCase {

    ReactionCountByTypeDTO execute(UUID targetId, String targetClass);
}
