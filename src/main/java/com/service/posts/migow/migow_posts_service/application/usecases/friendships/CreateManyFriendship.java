package com.service.posts.migow.migow_posts_service.application.usecases.friendships;

import java.util.List;

import org.springframework.stereotype.Component;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.posts.migow.migow_posts_service.domain.interfaces.usecases.friendships.CreateManyFriendshipUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CreateManyFriendship implements CreateManyFriendshipUseCase {
    private final FriendshipRepository friendshipRepository;

    @Override
    public List<Friendship> execute(List<Friendship> objs) {
        return friendshipRepository.createManyFriendship(objs);
    }

}
