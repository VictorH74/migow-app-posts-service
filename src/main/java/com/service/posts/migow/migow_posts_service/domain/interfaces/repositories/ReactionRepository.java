package com.service.posts.migow.migow_posts_service.domain.interfaces.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.application.dtos.DateRangeFilter;
import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface ReactionRepository {
    Long getReactionCountByTarget(String target);

    Page<Reaction> getAllTargetReaction(String target, String usernamePrefix, DateRangeFilter dateRangeFilter,
            Pageable pageable);

    Page<Reaction> getAllTargetReactionByReactionType(String target, String usernamePrefix, int reactionTypeCode,
            DateRangeFilter dateRangeFilter, Pageable pageable);

    Long getCountByReactionType(String target, int reactionTypeCode);

    Optional<Reaction> getReactionByOwnerId(UUID ownerId, String target);

    Reaction createUpdateReaction(Reaction obj);

    void deleteReactionById(UUID id);

    void deleteAllByTarget(String target);
}
