package com.service.posts.migow.migow_posts_service.application.usecases.users;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.GetUserByUsernameUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

@Component
public class GetUserByUsername implements GetUserByUsernameUseCase {
    private final UserRepository userRepository;

    public GetUserByUsername(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(String username) {
        // TODO: create handler execption
        return userRepository.getUserByUsername(username).get();
    }

}
