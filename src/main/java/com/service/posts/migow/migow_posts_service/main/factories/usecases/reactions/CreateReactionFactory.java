package com.service.posts.migow.migow_posts_service.main.factories.usecases.reactions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.CreateReactionUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.reactions.CreateReaction;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.ReactionRepositoryImpl;

@Configuration
public class CreateReactionFactory {

    @Bean
    public CreateReactionUseCase CreateReactionUseCase(ReactionRepositoryImpl reactionRepository) {
        return new CreateReaction(reactionRepository);
    }
}
