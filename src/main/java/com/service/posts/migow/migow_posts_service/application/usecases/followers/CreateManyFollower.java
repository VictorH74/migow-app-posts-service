package com.service.posts.migow.migow_posts_service.application.usecases.followers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.FollowerRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers.CreateManyFollowerUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Follower;

@Component
public class CreateManyFollower implements CreateManyFollowerUseCase {
    private final FollowerRepository followerRepository;

    public CreateManyFollower(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> execute(List<Follower> objs) {
        return followerRepository.createManyFollower(objs);
    }

}
