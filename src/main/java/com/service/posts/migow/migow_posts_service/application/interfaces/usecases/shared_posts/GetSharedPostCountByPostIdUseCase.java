package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.shared_posts;

import java.util.UUID;

public interface GetSharedPostCountByPostIdUseCase {
    Long execute(UUID postId);
}
