package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.posts;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.application.dtos.posts.PostResponseDTO;

public interface GetAllPopularFriendPostUseCase {
    Page<PostResponseDTO> execute(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable);
}
