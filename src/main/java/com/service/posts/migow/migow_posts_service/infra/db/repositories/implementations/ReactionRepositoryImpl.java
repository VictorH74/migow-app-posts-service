package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;
import com.service.posts.migow.migow_posts_service.domain.interfaces.repositories.ReactionRepository;
import com.service.posts.migow.migow_posts_service.infra.db.repositories.jpa.JpaReactionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class ReactionRepositoryImpl implements ReactionRepository {

    private final JpaReactionRepository jpaReactionRepository;

    @Override
    public Reaction createUpdateReaction(Reaction obj) {
        return jpaReactionRepository.save(obj);
    }

    @Override
    public void deleteReactionById(UUID id) {
        jpaReactionRepository.deleteById(id);

    }

    @Override
    public Long getCountByReactionType(String target, int reactionTypeCode) {
        return jpaReactionRepository.findCountByReactionType(target, reactionTypeCode);
    }

    @Override
    public Page<Reaction> getAllTargetReactionByReactionType(String target, String usernamePrefix, int reactionTypeCode,
            DateRangeFilter dateRangeFilter, Pageable pageable) {
        return jpaReactionRepository.findAllByReactioType(
                target,
                usernamePrefix,
                reactionTypeCode,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Page<Reaction> getAllTargetReaction(String target, String usernamePrefix, DateRangeFilter dateRangeFilter, Pageable pageable) {
        return jpaReactionRepository.findAll(
                target,
                usernamePrefix,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Long getReactionCountByTarget(String target) {
        return jpaReactionRepository.countByTarget(target);
    }

}
