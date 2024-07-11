package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Follower;

public interface CreateFollowerUseCase {
    Follower execute(UUID followerId, UUID followedId);
}
