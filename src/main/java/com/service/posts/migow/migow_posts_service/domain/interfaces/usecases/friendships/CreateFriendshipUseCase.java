package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;

public interface CreateFriendshipUseCase {
    Friendship execute(UUID userId, UUID userId2);
}
