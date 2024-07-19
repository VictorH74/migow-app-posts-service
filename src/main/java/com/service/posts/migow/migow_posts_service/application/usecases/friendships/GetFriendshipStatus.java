package com.service.posts.migow.migow_posts_service.application.usecases.friendships;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships.GetFriendshipStatusUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class GetFriendshipStatus implements GetFriendshipStatusUseCase {

    private final FriendshipRepository friendshipRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public GetFriendshipStatus(FriendshipRepository friendshipRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.friendshipRepository = friendshipRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public boolean execute(UUID userId, UUID userId2) {
        getUserByIdUseCase.execute(userId);
        getUserByIdUseCase.execute(userId2);
        return friendshipRepository.getFriendshipStatus(userId, userId2);
    }

}
