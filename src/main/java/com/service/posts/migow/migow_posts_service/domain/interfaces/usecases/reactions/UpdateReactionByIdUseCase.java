package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.UpdateReactionDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface UpdateReactionByIdUseCase {
    Reaction execute(UUID id, UpdateReactionDTO obj);
}
