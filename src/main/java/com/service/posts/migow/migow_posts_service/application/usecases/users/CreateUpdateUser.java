package com.service.posts.migow.migow_posts_service.application.usecases.users;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.CreateUpdateUserUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

@Component
public class CreateUpdateUser implements CreateUpdateUserUseCase {
    private final UserRepository userRepository;

    public CreateUpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(User obj) {
        if (obj.getId().toString().isEmpty())
            obj.setId(UUID.randomUUID());
            
        return userRepository.createUpdateUser(obj);
    }

}
