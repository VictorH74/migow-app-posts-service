package com.service.posts.migow.migow_posts_service.application.usecases.reactions;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions.DeleteAllReactionByTargetUseCase;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeleteAllReactionByTarget implements DeleteAllReactionByTargetUseCase {
    private final ReactionRepository reactionRepository;

    @Override
    public void execute(String target) {
        reactionRepository.deleteAllByTarget(target);
    }

}
