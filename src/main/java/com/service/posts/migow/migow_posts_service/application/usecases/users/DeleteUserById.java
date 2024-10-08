package com.service.posts.migow.migow_posts_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.DeleteUserByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeleteUserById implements DeleteUserByIdUseCase {

    private final UserRepository userRepository;

    @Override
    public void execute(UUID id) {
        userRepository.deleteById(id);

    }

}
