package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaReactionRepository;

@Repository
public class ReactionRepositoryImpl implements ReactionRepository {

    private final JpaReactionRepository JpaReactionRepository;

    public ReactionRepositoryImpl(
            com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaReactionRepository jpaReactionRepository) {
        JpaReactionRepository = jpaReactionRepository;
    }

    @Override
    public Reaction createReaction(Reaction obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteReactionById(UUID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Long getReactionCoundByPostId(UUID postId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reaction updateReaction(UUID id, Reaction obj) {
        // TODO Auto-generated method stub
        return null;
    }

}
