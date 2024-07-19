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

    @Query("SELECT p FROM Post p JOIN Friendship f ON p.owner.id = f.id.friendUser.id WHERE f.id.user.id = :userId ORDER BY p.createdAt DESC")
    public Page<Post> findAllFriendRecentPost(UUID userId, Pageable pageable);

    @Query("SELECT p FROM Post p " +
       "JOIN Friendship f ON p.owner.id = f.id.friendUser.id " +
       "LEFT JOIN Comment c ON p.id = c.post.id " +
       "LEFT JOIN Reaction r ON CONCAT('post_', p.id) = r.target " +
       "WHERE f.id.user.id = :userId " +
       "GROUP BY p.id " +
       "ORDER BY (COUNT(c.id) + COUNT(r.id)) DESC")
    public Page<Post> findAllFriendPopularPost(UUID userId, Pageable pageable);
}
