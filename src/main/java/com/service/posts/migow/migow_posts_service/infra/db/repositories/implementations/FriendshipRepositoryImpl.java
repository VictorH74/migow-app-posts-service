package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.FriendshipRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaFriendshipRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class FriendshipRepositoryImpl implements FriendshipRepository {

    private final JpaFriendshipRepository jpaFriendshipRepository;

    @Override
    public List<Friendship> createMany(List<Friendship> objs) {
        return jpaFriendshipRepository.saveAll(objs);
    }

    @Override
    public Friendship create(Friendship obj) {
        return jpaFriendshipRepository.save(obj);
    }

    @Override
    public void delete(FriendshipPK id) {
        jpaFriendshipRepository.deleteById(id);
    }

    @Override
    public boolean getStatusByUserId(UUID userId, UUID userId2) {
        return jpaFriendshipRepository.isFriend(userId, userId2);
    }

}
