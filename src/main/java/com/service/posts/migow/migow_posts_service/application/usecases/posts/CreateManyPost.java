package com.service.posts.migow.migow_posts_service.application.usecases.posts;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts.CreateManyPostUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateManyPost implements CreateManyPostUseCase {

    private final PostRepository postRepository;

    @Override
    public List<Post> execute(List<Post> objs) {
        return postRepository.createMany(objs);
    }

}
