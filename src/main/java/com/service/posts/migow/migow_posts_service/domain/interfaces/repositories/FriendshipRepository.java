package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;

public interface FriendshipRepository {

    List<Friendship> createMany(List<Friendship> objs);

    Friendship create(Friendship obj);

    boolean getStatusByUserId(UUID userId, UUID userId2);

    void delete(FriendshipPK id);

}
