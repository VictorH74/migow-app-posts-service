package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Follower;
import com.service.posts.migow.migow_posts_service.domain.pks.FollowerPK;

public interface JpaFollowerRepository extends JpaRepository<Follower, FollowerPK> {
    @Query("SELECT COUNT(f) > 0 FROM Follower f WHERE f.id.followerUser.id = :followerId AND f.id.followedUser.id = :followedId")
    public boolean isFollower(UUID followerId, UUID followedId);
}
