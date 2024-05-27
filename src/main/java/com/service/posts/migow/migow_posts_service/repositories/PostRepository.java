package com.service.posts.migow.migow_posts_service.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.entities.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query("SELECT *(p) FROM Post p WHERE p.owner.id = :userId")
    public Page<Post> findAllByUserId(UUID userId, Pageable pageable);

}
