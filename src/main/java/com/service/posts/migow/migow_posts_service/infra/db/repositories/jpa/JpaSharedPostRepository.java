package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.SharedPost;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.SharedPostPK;

public interface JpaSharedPostRepository
                extends JpaRepository<SharedPost, SharedPostPK> {

        @Query("SELECT COUNT(p) FROM SharedPost p WHERE p.id.post.id = :postId")
        long countByPostId(UUID postId);

}
