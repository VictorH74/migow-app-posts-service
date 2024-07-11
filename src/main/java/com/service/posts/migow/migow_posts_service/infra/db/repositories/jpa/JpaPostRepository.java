package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface JpaPostRepository extends JpaRepository<Post, UUID> {
    @Query("SELECT p FROM Post p WHERE p.owner.id = :userId")
    public Page<Post> findAllByUserId(UUID userId, Pageable pageable);

    @Query("SELECT p FROM Post p JOIN Follower f ON p.owner.id = f.id.followedUser.id WHERE f.id.followerUser.id = :followerId ORDER BY p.createdAt DESC")
    public Page<Post> findAllFollowedUserPost(UUID followerId, Pageable pageable);
}
