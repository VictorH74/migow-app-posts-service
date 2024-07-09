package com.service.posts.migow.migow_posts_service.main.factories.usecases.shared_posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.DeleteSharedPostByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.shared_posts.DeleteSharedPostById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.SharedPostRepositoryImpl;

@Configuration
public class DeleteSharedPostByIdFactory {
    @Bean
    public DeleteSharedPostByIdUseCase DeleteSharedPostByIdUseCase(SharedPostRepositoryImpl sharedPostRepository) {
        return new DeleteSharedPostById(sharedPostRepository);
    }

}
