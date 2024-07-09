package com.service.posts.migow.migow_posts_service.main.factories.usecases.reactions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.GetReactionCoundByPostIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.reactions.GetReactionCoundByPostId;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.ReactionRepositoryImpl;

@Configuration
public class GetReactionCoundByPostIdFactory {

    @Bean
    public GetReactionCoundByPostIdUseCase getReactionCoundByPostIdUseCase(ReactionRepositoryImpl reactionRepository) {
        return new GetReactionCoundByPostId(reactionRepository);
    }

}
