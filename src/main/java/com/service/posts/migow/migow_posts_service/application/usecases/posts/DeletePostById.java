package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.DeletePostByIdUseCase;

@Component
public class DeletePostById implements DeletePostByIdUseCase {
    private final PostRepository postRepository;

    public DeletePostById(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void execute(UUID id) {
        postRepository.deletePostById(id);

    }

}
