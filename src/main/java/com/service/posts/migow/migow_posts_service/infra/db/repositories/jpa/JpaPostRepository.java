package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface JpaPostRepository extends JpaRepository<Post, UUID> {
    @Query("SELECT p FROM Post p WHERE p.owner.id = :userId AND p.createdAt BETWEEN :startDate AND :endDate")
    public Page<Post> findAllByUserId(UUID userId, Instant startDate, Instant endDate, Pageable pageable);

    @Query("SELECT p FROM Post p " +
       "JOIN Friendship f ON p.owner.id = f.id.friendUser.id OR p.owner.id = f.id.user.id " +
       "LEFT JOIN Comment c ON p.id = c.postId " +
       "LEFT JOIN Reaction r ON CONCAT('post_', p.id) = r.target " +
       "WHERE (f.id.user.id = :userId OR f.id.friendUser.id = :userId) AND p.createdAt BETWEEN :startDate AND :endDate " +
       "GROUP BY p.id " +
       "ORDER BY p.createdAt DESC")
    public Page<Post> findAllFriendRecentPost(UUID userId, Instant startDate, Instant endDate, Pageable pageable);

    @Query("SELECT p FROM Post p " +
       "JOIN Friendship f ON p.owner.id = f.id.friendUser.id OR p.owner.id = f.id.user.id " +
       "LEFT JOIN Comment c ON p.id = c.postId " +
       "LEFT JOIN Reaction r ON CONCAT('post_', p.id) = r.target " +
       "WHERE (f.id.user.id = :userId OR f.id.friendUser.id = :userId) AND p.createdAt BETWEEN :startDate AND :endDate " +
       "GROUP BY p.id " +
       "ORDER BY (COUNT(c.id) + COUNT(r.id)) DESC")
    public Page<Post> findAllFriendPopularPost(UUID userId, Instant startDate, Instant endDate, Pageable pageable);
}
