package com.service.posts.migow.migow_posts_service.application.usecases.shared_posts;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.SharedPost;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.SharedPostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts.CreateSharedPostUseCase;

@Component
public class CreateSharedPost implements CreateSharedPostUseCase {
    private final SharedPostRepository sharedPostRepository;

    public CreateSharedPost(SharedPostRepository sharedPostRepository) {
        this.sharedPostRepository = sharedPostRepository;
    }

    @Override
    public SharedPost execute(SharedPost obj) {
        return sharedPostRepository.createSharedPost(obj);
    }

}
