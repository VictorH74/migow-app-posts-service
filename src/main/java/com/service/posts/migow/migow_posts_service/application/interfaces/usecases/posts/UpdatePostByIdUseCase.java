package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.infra.http.dtos.posts.UpdatePostDTO;

public interface UpdatePostByIdUseCase {
    Post execute(UUID id, UpdatePostDTO obj);

}
