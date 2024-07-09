package com.service.posts.migow.migow_posts_service.application.interfaces.repositories;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

public interface ReactionRepository {
    Long getReactionCoundByPostId(UUID postId);

    Reaction createReaction(Reaction obj);

    void deleteReactionById(UUID id);

    Reaction updateReaction(UUID id, Reaction obj);

}
