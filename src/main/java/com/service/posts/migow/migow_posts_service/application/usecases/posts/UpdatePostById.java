package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.UpdatePostByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

@Component
public class UpdatePostById implements UpdatePostByIdUseCase {
    private final PostRepository postRepository;

    public UpdatePostById(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post execute(UUID id, Post obj) {
        // TODO impl not fount post
        return postRepository.updatePostById(id, obj);
    }

}
