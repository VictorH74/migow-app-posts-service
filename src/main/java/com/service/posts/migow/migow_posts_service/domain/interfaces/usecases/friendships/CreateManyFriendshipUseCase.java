package com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships;

import java.util.List;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;

public interface CreateManyFriendshipUseCase {
    List<Friendship> execute(List<Friendship> objs);
}
