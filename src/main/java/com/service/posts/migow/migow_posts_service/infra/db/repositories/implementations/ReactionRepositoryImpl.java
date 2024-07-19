package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaReactionRepository;

@Repository
public class ReactionRepositoryImpl implements ReactionRepository {

    private final JpaReactionRepository jpaReactionRepository;

    public ReactionRepositoryImpl(JpaReactionRepository jpaReactionRepository) {
        this.jpaReactionRepository = jpaReactionRepository;
    }

    @Override
    public Reaction createUpdateReaction(Reaction obj) {
        return jpaReactionRepository.save(obj);
    }

    @Override
    public void deleteReactionById(UUID id) {
        jpaReactionRepository.deleteById(id);

    }

    @Override
    public Page<Reaction> getAllReactionByTarget(String target, Pageable pageable) {
        return jpaReactionRepository.findAllByTarget(target, pageable);
    }

    @Override
    public Long getReactionCountByTarget(String target) {
        return jpaReactionRepository.countByTarget(target);
    }

}
