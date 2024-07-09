package com.service.posts.migow.migow_posts_service.application.usecases.shared_posts;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.SharedPostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.CreateSharedPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.SharedPost;

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
