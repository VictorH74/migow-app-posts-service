package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.Optional;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface GetReactionByOwnerIdUseCase {
    Optional<Reaction> execute(UUID ownerId, String target);
}
