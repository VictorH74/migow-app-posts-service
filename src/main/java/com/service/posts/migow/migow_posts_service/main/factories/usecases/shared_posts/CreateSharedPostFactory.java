package com.service.posts.migow.migow_posts_service.main.factories.usecases.shared_posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.CreateSharedPostUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.shared_posts.CreateSharedPost;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.SharedPostRepositoryImpl;

@Configuration
public class CreateSharedPostFactory {

    @Bean
    public CreateSharedPostUseCase createSharedPostUseCase(SharedPostRepositoryImpl sharedPostRepository) {
        return new CreateSharedPost(sharedPostRepository);
    }

}
