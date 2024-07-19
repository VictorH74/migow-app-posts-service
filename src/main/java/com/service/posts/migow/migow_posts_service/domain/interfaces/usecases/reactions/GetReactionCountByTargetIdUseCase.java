package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.reactions;

import java.util.UUID;

public interface GetReactionCountByTargetIdUseCase {
    Long execute(UUID targetId, Class<?> targetClass);

}
