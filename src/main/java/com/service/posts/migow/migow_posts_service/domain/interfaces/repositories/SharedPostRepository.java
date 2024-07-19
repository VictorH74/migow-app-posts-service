package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.SharedPost;

public interface SharedPostRepository {
    Long getSharedPostCountByPostId(UUID postId);

    SharedPost createSharedPost(SharedPost obj);

    void deleteSharedPostById(UUID id);
}
