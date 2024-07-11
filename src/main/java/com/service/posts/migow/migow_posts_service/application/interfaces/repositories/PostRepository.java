package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface PostRepository {
    Page<Post> getAllPostByUserId(UUID userId, Pageable pageable);

    Page<Post> getAllFollowedUserPost(UUID followerId, Pageable pageable);

    Optional<Post> getPostById(UUID id);

    List<Post> createManyPost(List<Post> objs);

    Post createUpdatePost(Post obj);

    void deletePostById(UUID id);

}
