package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaPostRepository;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    public PostRepositoryImpl(JpaPostRepository jpaPostRepository) {
        this.jpaPostRepository = jpaPostRepository;
    }

    @Override
    public Post createPost(Post obj) {
        return jpaPostRepository.save(obj);
    }

    @Override
    public Page<Post> getAllPostByUserId(UUID userId, Pageable pageable) {
        return jpaPostRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Optional<Post> getPostById(UUID id) {
        return jpaPostRepository.findById(id);
    }

    @Override
    public void deletePostById(UUID id) {
        jpaPostRepository.deleteById(id);

    }

    @Override
    public Post updatePostById(UUID id, Post obj) {
        // TODO Auto-generated method stub
        return null;
    }

}
