package com.service.posts.migow.migow_posts_service.application.usecases.shared_posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.SharedPostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts.DeleteSharedPostByIdUseCase;

@Component
public class DeleteSharedPostById implements DeleteSharedPostByIdUseCase {
    private final SharedPostRepository sharedPostRepository;

    public DeleteSharedPostById(SharedPostRepository sharedPostRepository) {
        this.sharedPostRepository = sharedPostRepository;
    }

    @Override
    public void execute(UUID id) {
        sharedPostRepository.deleteSharedPostById(id);

    }

}
