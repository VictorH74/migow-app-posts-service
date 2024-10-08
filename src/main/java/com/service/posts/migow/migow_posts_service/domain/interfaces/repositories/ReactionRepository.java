package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface ReactionRepository {

    Reaction createUpdate(Reaction obj);

    Long getCountByTarget(String target);

    Optional<Reaction> getById(UUID id);

    Optional<Reaction> getByOwnerId(UUID ownerId, String target);

    Page<Reaction> getAllByTarget(String target, String usernamePrefix, DateRangeFilter dateRangeFilter,
            Pageable pageable);

    Page<Reaction> getAllByTargetAndReactionType(String target, String usernamePrefix, int reactionTypeCode,
            DateRangeFilter dateRangeFilter, Pageable pageable);

    Long getCountByReactionType(String target, int reactionTypeCode);

    void deleteById(UUID id);

    void deleteAllByTarget(String target);
}
