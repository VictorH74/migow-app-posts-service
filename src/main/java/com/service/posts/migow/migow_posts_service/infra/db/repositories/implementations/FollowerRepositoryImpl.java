package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.FollowerRepository;
import com.service.posts.migow.migow_posts_service.domain.entities.Follower;
import com.service.posts.migow.migow_posts_service.domain.pks.FollowerPK;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaFollowerRepository;

@Repository
public class FollowerRepositoryImpl implements FollowerRepository {
    private final JpaFollowerRepository jpaFollowerRepository;

    @Override
    public List<Follower> createManyFollower(List<Follower> objs) {
        return jpaFollowerRepository.saveAll(objs);
    }

    public FollowerRepositoryImpl(JpaFollowerRepository jpaFollowerRepository) {
        this.jpaFollowerRepository = jpaFollowerRepository;
    }

    @Override
    public Follower createFollower(Follower obj) {
        return jpaFollowerRepository.save(obj);
    }

    @Override
    public void deleteFollowerById(FollowerPK id) {
        jpaFollowerRepository.deleteById(id);
    }

    @Override
    public boolean getIsFollowerStatus(UUID followerId, UUID followedId) {
        return jpaFollowerRepository.isFollower(followerId, followedId);
    }

}
