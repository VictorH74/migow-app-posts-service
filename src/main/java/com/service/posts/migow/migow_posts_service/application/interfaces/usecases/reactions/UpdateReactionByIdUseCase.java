package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.reactions.UpdateReactionDTO;

public interface UpdateReactionByIdUseCase {
    Reaction execute(UUID id, UpdateReactionDTO obj);
}
