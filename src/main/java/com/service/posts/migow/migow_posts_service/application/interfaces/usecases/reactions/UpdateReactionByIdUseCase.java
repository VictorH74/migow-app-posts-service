package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface UpdateReactionByIdUseCase {
    Reaction execute(UUID id, Reaction obj);
}
