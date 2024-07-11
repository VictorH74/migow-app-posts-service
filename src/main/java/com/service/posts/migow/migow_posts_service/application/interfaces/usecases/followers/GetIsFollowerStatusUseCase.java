package com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers;

import java.util.UUID;

public interface GetIsFollowerStatusUseCase {
    boolean execute(UUID followerId, UUID followedId);
}
