package com.service.posts.migow.migow_posts_service.main.factories.usecases.posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.UpdatePostByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.posts.UpdatePostById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.PostRepositoryImpl;

@Configuration
public class UpdatePostByIdFactory {
    @Bean
    public UpdatePostByIdUseCase updatePostByIdUseCase(PostRepositoryImpl postRepository) {
        return new UpdatePostById(postRepository);
    }
}
