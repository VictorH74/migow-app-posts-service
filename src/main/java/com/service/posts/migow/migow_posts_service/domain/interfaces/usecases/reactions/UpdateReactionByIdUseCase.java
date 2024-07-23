package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.reactions.SimpleReactionDTO;
import com.service.posts.migow.migow_posts_service.application.dtos.reactions.UpdateReactionDTO;

public interface UpdateReactionByIdUseCase {
    SimpleReactionDTO execute(UUID id, UpdateReactionDTO obj);
}
