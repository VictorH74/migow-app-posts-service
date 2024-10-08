package com.service.posts.migow.migow_posts_service.application.usecases.users;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.CreateManyUserUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateManyUser implements CreateManyUserUseCase {

    private final UserRepository userRepository;

    @Override
    public List<User> execute(List<User> objs) {
        return userRepository.createMany(objs);
    }

}
