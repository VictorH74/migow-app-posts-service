package com.service.posts.migow.migow_posts_service.main.factories.usecases.comments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.comments.GetCommentCountByPostId;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.CommentRepositoryImpl;

@Configuration
public class GetCommentCountByPostIdFactory {
@Bean
    public GetCommentCountByPostIdUseCase GetCommentCountByPostIdUseCase(CommentRepositoryImpl commentRepository) {
        return new GetCommentCountByPostId(commentRepository);
    }

}
