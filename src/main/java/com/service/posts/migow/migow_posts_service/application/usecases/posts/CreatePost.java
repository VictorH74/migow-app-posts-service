package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreatePostUseCase;

@Component
public class CreatePost implements CreatePostUseCase {
    private final PostRepository postRepository;

    public CreatePost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post execute(Post obj) {
        return postRepository.createUpdatePost(obj);
    }
}
