package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.SharedPost;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.SharedPostRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaSharedPostRepository;

@Repository
public class SharedPostRepositoryImpl implements SharedPostRepository {
    private final JpaSharedPostRepository jpaSharedPostRepository;

    public SharedPostRepositoryImpl(JpaSharedPostRepository jpaSharedPostRepository) {
        this.jpaSharedPostRepository = jpaSharedPostRepository;
    }

    @Override
    public SharedPost createSharedPost(SharedPost obj) {
        return jpaSharedPostRepository.save(obj);
    }

    @Override
    public void deleteSharedPostById(UUID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Long getSharedPostCountByPostId(UUID postId) {
        return jpaSharedPostRepository.countByPostId(postId);
    }

}
