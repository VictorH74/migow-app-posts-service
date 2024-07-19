package com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.posts.migow.migow_posts_service.domain.entities.Friendship;
import com.service.posts.migow.migow_posts_service.domain.entities.pks.FriendshipPK;

public interface JpaFriendshipRepository extends JpaRepository<Friendship, FriendshipPK> {
    @Query("SELECT COUNT(f) > 0 FROM Friendship f WHERE f.id.user.id = :userId AND f.id.friendUser.id = :userId2")
    public boolean isFriend(UUID userId, UUID userId2);
}
