package com.service.posts.migow.migow_posts_service.main.factories.usecases.posts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.comments.GetCommentCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts.GetAllPostByUserIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.GetReactionCoundByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts.GetSharedPostCountByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.posts.GetAllPostByUserId;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.PostRepositoryImpl;

@Configuration
public class GetAllPostByUserIdFactory {
    @Bean
    public GetAllPostByUserIdUseCase getAllPostByUserIdUseCase(PostRepositoryImpl postRepository,
            GetReactionCoundByPostIdUseCase getReactionCoundByPostIdUseCase,
            GetCommentCountByPostIdUseCase getCommentCountByPostIdUseCase,
            GetSharedPostCountByPostIdUseCase getSharedPostCountByPostIdUseCase) {
        return new GetAllPostByUserId(postRepository, getReactionCoundByPostIdUseCase, getCommentCountByPostIdUseCase,
                getSharedPostCountByPostIdUseCase);
    }
}
