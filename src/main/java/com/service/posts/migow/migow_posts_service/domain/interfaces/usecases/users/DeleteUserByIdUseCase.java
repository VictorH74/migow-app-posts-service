package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users;

import java.util.UUID;

public interface DeleteUserByIdUseCase {
    void execute(UUID id);
}
