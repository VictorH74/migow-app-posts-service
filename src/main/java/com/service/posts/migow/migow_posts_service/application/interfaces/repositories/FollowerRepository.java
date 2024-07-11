package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.List;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Follower;
import com.service.posts.migow.migow_posts_service.domain.pks.FollowerPK;

public interface FollowerRepository {
    List<Follower> createManyFollower(List<Follower> objs);

    Follower createFollower(Follower obj);

    boolean getIsFollowerStatus(UUID followerId, UUID followedId);

    void deleteFollowerById(FollowerPK id);

}
