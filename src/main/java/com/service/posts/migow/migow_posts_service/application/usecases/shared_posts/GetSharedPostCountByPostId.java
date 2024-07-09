package com.service.posts.migow.migow_posts_service.application.usecases.shared_posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.SharedPostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;

@Component
public class GetSharedPostCountByPostId implements GetSharedPostCountByPostIdUseCase {

    private final SharedPostRepository sharedPostRepository;

    public GetSharedPostCountByPostId(SharedPostRepository sharedPostRepository) {
        this.sharedPostRepository = sharedPostRepository;
    }

    @Override
    public Long execute(UUID postId) {
        return sharedPostRepository.getSharedPostCountByPostId(postId);
    }

}
