package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.UpdatePostDTO;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface UpdatePostByIdUseCase {
    Post execute(UUID id, UpdatePostDTO obj);

}
