package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships;

import java.util.UUID;

public interface DeleteFriendshipUseCase {
    void execute(UUID userId, UUID userId2);
}
