package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;

public interface GetPostByIdUseCase {

    PostResponseDTO execute(UUID id);
}
