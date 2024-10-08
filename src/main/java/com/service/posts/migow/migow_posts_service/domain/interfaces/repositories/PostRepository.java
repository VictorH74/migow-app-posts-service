package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;

public interface PostRepository {

    Page<Post> getAllByUserId(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable);

    Page<Post> getAllFriendRecentPost(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable);

    Page<Post> getAllFriendPopularPost(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable);

    Optional<Post> getById(UUID id);

    List<Post> createMany(List<Post> objs);

    Post createUpdate(Post obj);

    Long getShareCount(UUID postId);

    void deleteById(UUID id);

}
