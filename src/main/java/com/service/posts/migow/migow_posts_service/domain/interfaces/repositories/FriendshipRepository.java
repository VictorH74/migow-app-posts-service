package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;

public interface FriendshipRepository {
    List<Friendship> createManyFriendship(List<Friendship> objs);

    Friendship createFriendship(Friendship obj);

    boolean getFriendshipStatus(UUID userId, UUID userId2);

    void deleteFriendship(FriendshipPK id);

}
