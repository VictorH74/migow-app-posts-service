package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface GetAllReactionByTargetIdUseCase {
    Page<Reaction> execute(UUID targetId, Class<?> targetClass, Pageable pageable);
}
