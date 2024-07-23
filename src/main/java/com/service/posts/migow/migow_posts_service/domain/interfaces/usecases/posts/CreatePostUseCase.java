package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.CreatePostDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface CreatePostUseCase {
    Post execute(CreatePostDTO obj);
}
