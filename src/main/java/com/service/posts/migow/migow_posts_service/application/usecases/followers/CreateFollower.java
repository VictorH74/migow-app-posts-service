package com.service.posts.migow.migow_posts_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.FollowerRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers.CreateFollowerUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.Follower;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.pks.FollowerPK;

@Component
public class CreateFollower implements CreateFollowerUseCase {

    private final FollowerRepository followerRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public CreateFollower(FollowerRepository followerRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.followerRepository = followerRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public Follower execute(UUID followerId, UUID followedId) {
        FollowerPK followerPK = new FollowerPK();
        User followerUser = getUserByIdUseCase.execute(followerId);
        User followedUser = getUserByIdUseCase.execute(followedId);
        followerPK.setFollowerUser(followerUser);
        followerPK.setFollowedUser(followedUser);
        Follower f = new Follower();
        f.setId(followerPK);
        return followerRepository.createFollower(f);
    }

}
