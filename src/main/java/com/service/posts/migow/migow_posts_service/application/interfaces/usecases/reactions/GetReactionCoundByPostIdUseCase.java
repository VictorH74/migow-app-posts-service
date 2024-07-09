package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.reactions;

import java.util.UUID;

public interface GetReactionCoundByPostIdUseCase {
    Long execute(UUID postId);

}
