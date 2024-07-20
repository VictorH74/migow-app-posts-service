package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.DeletePostByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeletePostById implements DeletePostByIdUseCase {
    private final PostRepository postRepository;

    @Override
    public void execute(UUID id) {
        postRepository.deletePostById(id);

    }

}
