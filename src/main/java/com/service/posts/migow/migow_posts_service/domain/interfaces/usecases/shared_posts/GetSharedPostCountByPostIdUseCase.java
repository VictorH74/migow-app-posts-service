package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts;

import java.util.UUID;

public interface GetSharedPostCountByPostIdUseCase {
    Long execute(UUID postId);
}
