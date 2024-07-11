package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.reactions.CreateReactionDTO;

public interface CreateReactionUseCase {
    Reaction execute(CreateReactionDTO obj, UUID targetId, Class<?> targetClass);

}
