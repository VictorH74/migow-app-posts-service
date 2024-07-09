package com.service.posts.migow.migow_posts_service.main.factories.usecases.posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.DeletePostByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.posts.DeletePostById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.PostRepositoryImpl;

@Configuration
public class DeletePostByIdFactory {
    @Bean
    public DeletePostByIdUseCase deletePostByIdUseCase(PostRepositoryImpl postRepository) {
        return new DeletePostById(postRepository);
    }
}
