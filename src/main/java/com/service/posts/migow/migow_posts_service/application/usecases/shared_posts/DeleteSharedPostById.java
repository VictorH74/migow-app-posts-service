package com.service.posts.migow.migow_posts_service.application.usecases.shared_posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.SharedPostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.DeleteSharedPostByIdUseCase;

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
