package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public interface GetAllUserUseCase {
    Page<User> execute(Pageable pageable);
}
