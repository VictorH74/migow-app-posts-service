package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaFriendshipRepository;

@Repository
public class FriendshipRepositoryImpl implements FriendshipRepository {
    private final JpaFriendshipRepository jpaFriendshipRepository;

    @Override
    public List<Friendship> createManyFriendship(List<Friendship> objs) {
        return jpaFriendshipRepository.saveAll(objs);
    }

    public FriendshipRepositoryImpl(JpaFriendshipRepository jpaFriendshipRepository) {
        this.jpaFriendshipRepository = jpaFriendshipRepository;
    }

    @Override
    public Friendship createFriendship(Friendship obj) {
        return jpaFriendshipRepository.save(obj);
    }

    @Override
    public void deleteFriendship(FriendshipPK id) {
        jpaFriendshipRepository.deleteById(id);
    }

    @Override
    public boolean getFriendshipStatus(UUID userId, UUID userId2) {
        return jpaFriendshipRepository.isFriend(userId, userId2);
    }

}
