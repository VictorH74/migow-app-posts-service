package com.service.posts.migow.migow_posts_service.application.usecases.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.UserRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.GetAllUserUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.User;

@Component
public class GetAllUser implements GetAllUserUseCase {
    private final UserRepository userRepository;

    public GetAllUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> execute(Pageable pageable) {
        return userRepository.getAllUser(pageable);
    }

}
