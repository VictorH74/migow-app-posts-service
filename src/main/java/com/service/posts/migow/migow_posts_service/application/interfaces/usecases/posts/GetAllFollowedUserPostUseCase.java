package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.infra.http.dtos.posts.PostResponseDTO;

public interface GetAllFollowedUserPostUseCase {
    Page<PostResponseDTO> execute(UUID followerId, Pageable pageable);
}
