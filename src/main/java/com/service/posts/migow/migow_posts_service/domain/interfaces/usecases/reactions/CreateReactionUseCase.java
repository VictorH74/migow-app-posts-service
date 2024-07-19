package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.CreateReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface CreateReactionUseCase {
    Reaction execute(CreateReactionDTO obj, UUID targetId, Class<?> targetClass);

}
