package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface CreateManyUserUseCase {
    List<User> execute(List<User> objs);
}
