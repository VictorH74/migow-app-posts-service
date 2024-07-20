package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.GetPostByIdUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GetPostById implements GetPostByIdUseCase {
    private final PostRepository postRepository;

    @Override
    public Post execute(UUID id) {
        // TODO: impl not found error
        return postRepository.getPostById(id).get();
    }

}
