package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface GetUserByIdUseCase {
    User execute(UUID id);
}
