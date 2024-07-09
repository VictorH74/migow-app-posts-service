package com.service.posts.migow.migow_posts_service.main.factories.usecases.reactions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions.DeleteReactionByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.usecases.reactions.DeleteReactionById;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations.ReactionRepositoryImpl;

@Configuration
public class DeleteReactionByIdFactory {
    @Bean
    public DeleteReactionByIdUseCase DeleteReactionByIdUseCase(ReactionRepositoryImpl reactionRepository) {
        return new DeleteReactionById(reactionRepository);
    }
}
