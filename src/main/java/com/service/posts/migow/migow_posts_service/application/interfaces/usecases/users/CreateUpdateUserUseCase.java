package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface CreateUpdateUserUseCase {
    User execute(User obj);
}
