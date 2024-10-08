package com.service.posts.migow.migow_posts_service.infra.db.repositories.implementations;

import java.util.Optional;
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
    public Optional<Reaction> getById(UUID id) {
        return jpaReactionRepository.findById(id);
    }

    @Override
    public Optional<Reaction> getByOwnerId(UUID ownerId, String target) {
        return jpaReactionRepository.findByOwnerId(ownerId, target);
    }

    @Override
    public void deleteAllByTarget(String target) {
        jpaReactionRepository.deleteAllByTarget(target);

    }

    @Override
    public Reaction createUpdate(Reaction obj) {
        return jpaReactionRepository.save(obj);
    }

    @Override
    public void deleteById(UUID id) {
        jpaReactionRepository.deleteById(id);

    }

    @Override
    public Long getCountByReactionType(String target, int reactionTypeCode) {
        return jpaReactionRepository.findCountByReactionType(target, reactionTypeCode);
    }

    @Override
    public Page<Reaction> getAllByTargetAndReactionType(String target, String usernamePrefix, int reactionTypeCode,
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
    public Page<Reaction> getAllByTarget(String target, String usernamePrefix, DateRangeFilter dateRangeFilter,
            Pageable pageable) {
        return jpaReactionRepository.findAll(
                target,
                usernamePrefix,
                dateRangeFilter.getStartDate(),
                dateRangeFilter.getEndDate(),
                pageable);
    }

    @Override
    public Long getCountByTarget(String target) {
        return jpaReactionRepository.countByTarget(target);
    }

}
