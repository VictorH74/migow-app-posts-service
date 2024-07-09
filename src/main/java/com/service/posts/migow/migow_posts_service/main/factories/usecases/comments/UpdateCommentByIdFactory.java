package com.service.posts.migow.migow_posts_service.main.factories.usecases.comments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.UpdateCommentByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.comments.UpdateCommentById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.CommentRepositoryImpl;

@Configuration
public class UpdateCommentByIdFactory {
    @Bean
    public UpdateCommentByIdUseCase UpdateCommentByIdUseCase(CommentRepositoryImpl commentRepository) {
        return new UpdateCommentById(commentRepository);
    }

}
