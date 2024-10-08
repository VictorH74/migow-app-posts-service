package com.service.posts.migow.migow_posts_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetUserById implements GetUserByIdUseCase {

    private final UserRepository userRepository;

    @Override
    public User execute(UUID id) {
        // TODO: create handler execption
        return userRepository.getById(id).get();
    }

}
