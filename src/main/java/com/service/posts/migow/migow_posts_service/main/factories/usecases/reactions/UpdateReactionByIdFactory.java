package com.service.posts.migow.migow_posts_service.main.factories.usecases.reactions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.UpdateReactionByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.reactions.UpdateReactionById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.ReactionRepositoryImpl;

@Configuration
public class UpdateReactionByIdFactory {
    @Bean
    public UpdateReactionByIdUseCase UpdateReactionByIdUseCase(ReactionRepositoryImpl reactionRepository) {
        return new UpdateReactionById(reactionRepository);
    }

}
