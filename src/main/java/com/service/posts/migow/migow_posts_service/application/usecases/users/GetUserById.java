package com.service.posts.migow.migow_posts_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

@Component
public class GetUserById implements GetUserByIdUseCase {
    private final UserRepository userRepository;

    public GetUserById(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(UUID id) {
        // TODO: create handler execption
        return userRepository.getUserById(id).get();
    }

}
