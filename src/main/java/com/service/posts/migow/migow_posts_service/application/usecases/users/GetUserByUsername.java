package com.service.posts.migow.migow_posts_service.application.usecases.users;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByUsernameUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetUserByUsername implements GetUserByUsernameUseCase {

    private final UserRepository userRepository;

    @Override
    public User execute(String username) {
        // TODO: create handler execption
        return userRepository.getByUsername(username).get();
    }

}
