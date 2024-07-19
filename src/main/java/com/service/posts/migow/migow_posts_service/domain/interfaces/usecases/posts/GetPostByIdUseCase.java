package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface GetPostByIdUseCase {
    Post execute(UUID id);
}
