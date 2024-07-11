package com.service.posts.migow.migow_posts_service.application.usecases.followers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.FollowerRepository;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.followers.DeleteFollowerByIdUseCase;
import com.service.posts.migow.migow_posts_service.application.interfaces.usecases.users.GetUserByIdUseCase;
import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.pks.FollowerPK;

@Component
public class DeleteFollowerById implements DeleteFollowerByIdUseCase {

    private final FollowerRepository followerRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public DeleteFollowerById(FollowerRepository followerRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.followerRepository = followerRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public void execute(UUID followerId, UUID followedId) {
        FollowerPK followerPK = new FollowerPK();
        User followerUser = getUserByIdUseCase.execute(followerId);
        User followedUser = getUserByIdUseCase.execute(followedId);
        followerPK.setFollowerUser(followerUser);
        followerPK.setFollowedUser(followedUser);
        followerRepository.deleteFollowerById(followerPK);
    }

}
