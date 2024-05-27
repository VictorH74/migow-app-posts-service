package com.service.posts.migow.migow_posts_service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.entities.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, UUID> {
    @Query("SELECT COUNT(r) FROM Reaction r WHERE r.target.postId = :postId")
    long countByPostId(UUID postId);

}
