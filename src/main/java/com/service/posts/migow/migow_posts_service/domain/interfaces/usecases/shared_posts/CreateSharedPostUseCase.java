package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.shared_posts;

import com.service.posts.migow.migow_posts_service.domain.entities.SharedPost;

public interface CreateSharedPostUseCase {
    SharedPost execute(SharedPost obj);
}
