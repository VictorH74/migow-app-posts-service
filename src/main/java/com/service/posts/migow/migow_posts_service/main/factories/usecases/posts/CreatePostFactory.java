package com.service.posts.migow.migow_posts_service.main.factories.usecases.posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.CreatePostUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.posts.CreatePost;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.PostRepositoryImpl;

@Configuration
public class CreatePostFactory {
    @Bean
    public CreatePostUseCase createPostUseCase(PostRepositoryImpl postRepository) {
        return new CreatePost(postRepository);
    }

}
