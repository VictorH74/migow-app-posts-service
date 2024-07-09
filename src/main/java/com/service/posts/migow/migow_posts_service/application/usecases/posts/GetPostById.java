package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public class GetPostById implements GetPostByIdUseCase {
    private final PostRepository postRepository;

    public GetPostById(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post execute(UUID id) {
        // TODO: impl not found error
        return postRepository.getPostById(id).get();
    }

}
