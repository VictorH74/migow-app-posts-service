package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.CreateManyPostUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

@Component
public class CreateManyPost implements CreateManyPostUseCase {
    private final PostRepository postRepository;

    public CreateManyPost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> execute(List<Post> objs) {
        return postRepository.createManyPost(objs);
    }

}
