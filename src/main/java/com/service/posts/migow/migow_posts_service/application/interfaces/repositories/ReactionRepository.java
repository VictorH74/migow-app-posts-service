package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface ReactionRepository {
    Long getReactionCountByTarget(String target);

    Page<Reaction> getAllReactionByTarget(String target, Pageable pageable);

    List<Reaction> createManyReaction(List<Reaction> objs);

    Reaction createUpdateReaction(Reaction obj);

    void deleteReactionById(UUID id);
}
