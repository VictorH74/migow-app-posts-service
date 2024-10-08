package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaPostRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Repository
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public Long getShareCount(UUID postId) {
        return jpaPostRepository.findShareCount(postId);
    }

    @Override
    public Post createUpdate(Post obj) {
        return jpaPostRepository.save(obj);
    }

    @Override
    public List<Post> createMany(List<Post> objs) {
        return jpaPostRepository.saveAllAndFlush(objs);
    }

    @Override
    public Page<Post> getAllByUserId(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        log.info("getAllPostByUserId > dateRangeFilter: " + dateRangeFilter.toString());
        return jpaPostRepository.findAllByUserId(
                userId,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Page<Post> getAllFriendRecentPost(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        log.info("getAllFriendRecentPost > dateRangeFilter: " + dateRangeFilter.toString());
        return jpaPostRepository.findAllFriendRecentPost(
                userId,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Page<Post> getAllFriendPopularPost(UUID userId, DateRangeFilter dateRangeFilter, Pageable pageable) {
        log.info("getAllFriendPopularPost > dateRangeFilter: " + dateRangeFilter.toString());
        return jpaPostRepository.findAllFriendPopularPost(
                userId,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Optional<Post> getById(UUID id) {
        return jpaPostRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        jpaPostRepository.deleteById(id);

    }

}
