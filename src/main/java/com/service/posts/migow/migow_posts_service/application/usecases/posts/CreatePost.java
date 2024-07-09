package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public class CreatePost implements CreatePostUseCase {
    private final PostRepository postRepository;

    public CreatePost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post execute(Post obj) {
        return postRepository.createPost(obj);
    }
}
