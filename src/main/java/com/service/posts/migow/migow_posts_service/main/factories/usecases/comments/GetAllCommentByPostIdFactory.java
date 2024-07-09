package com.service.posts.migow.migow_posts_service.main.factories.usecases.comments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetAllCommentByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.comments.GetAllCommentByPostId;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.CommentRepositoryImpl;

@Configuration
public class GetAllCommentByPostIdFactory{

   @Bean
    public GetAllCommentByPostIdUseCase GetAllCommentByPostIdUseCase(CommentRepositoryImpl commentRepository) {
        return new GetAllCommentByPostId(commentRepository);
    }

}
