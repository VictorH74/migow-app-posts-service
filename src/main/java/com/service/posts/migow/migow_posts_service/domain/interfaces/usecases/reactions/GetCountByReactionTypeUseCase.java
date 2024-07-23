package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

public interface GetCountByReactionTypeUseCase {
    public Long execute(String target, int reactionTypeCode);
}