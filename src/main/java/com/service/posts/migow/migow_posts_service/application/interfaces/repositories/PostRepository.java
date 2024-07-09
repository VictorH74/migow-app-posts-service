package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface PostRepository {
    Page<Post> getAllPostByUserId(UUID userId, Pageable pageable);

    Optional<Post> getPostById(UUID id);

    Post createPost(Post obj);

    Post updatePostById(UUID id, Post obj);

    void deletePostById(UUID id);

}
