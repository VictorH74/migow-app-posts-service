package com.service.posts.migow.migow_posts_service.application.usecases.friendships;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.User;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships.DeleteFriendshipUseCase;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.users.GetUserByIdUseCase;

@Component
public class DeleteFriendship implements DeleteFriendshipUseCase {

    private final FriendshipRepository friendshipRepository;
    private final GetUserByIdUseCase getUserByIdUseCase;

    public DeleteFriendship(FriendshipRepository friendshipRepository, GetUserByIdUseCase getUserByIdUseCase) {
        this.friendshipRepository = friendshipRepository;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

    @Override
    public void execute(UUID userId, UUID userId2) {
        FriendshipPK friendshipPK = new FriendshipPK();
        User user = getUserByIdUseCase.execute(userId);
        User friendUser = getUserByIdUseCase.execute(userId2);
        friendshipPK.setUser(user);
        friendshipPK.setFriendUser(friendUser);
        friendshipRepository.deleteFriendship(friendshipPK);
    }

}
