package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.Post;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.PostRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaPostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public Post createUpdatePost(Post obj) {
        return jpaPostRepository.save(obj);
    }

    @Override
    public List<Post> createManyPost(List<Post> objs) {
        return jpaPostRepository.saveAll(objs);
    }

    @Override
    public Page<Post> getAllPostByUserId(UUID userId, Pageable pageable) {
        return jpaPostRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public Page<Post> getAllFriendRecentPost(UUID userId, Pageable pageable) {
        return jpaPostRepository.findAllFriendRecentPost(userId, pageable);
    }

    @Override
    public Page<Post> getAllFriendPopularPost(UUID userId, Pageable pageable) {
        return jpaPostRepository.findAllFriendPopularPost(userId, pageable);
    }

    @Override
    public Optional<Post> getPostById(UUID id) {
        return jpaPostRepository.findById(id);
    }

    @Override
    public void deletePostById(UUID id) {
        jpaPostRepository.deleteById(id);

    }

}
