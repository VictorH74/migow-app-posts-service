package com.service.posts.migow.migow_posts_service.main.factories.usecases.posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.posts.GetPostById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.PostRepositoryImpl;

@Configuration
public class GetPostByIdFactory {
    @Bean
    public GetPostByIdUseCase getPostByIdUseCase(PostRepositoryImpl postRepository) {
        return new GetPostById(postRepository);
    }
}
