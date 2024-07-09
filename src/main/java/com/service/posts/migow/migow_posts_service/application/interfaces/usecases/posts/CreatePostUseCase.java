package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface CreatePostUseCase {
    Post execute(Post obj);
}
