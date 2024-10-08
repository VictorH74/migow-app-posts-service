package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import java.util.UUID;

public interface GetPostShareCountUseCase {

    Long execute(UUID id);
}
