package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface UpdatePostByIdUseCase {
    Post execute(UUID id, Post obj);

}
