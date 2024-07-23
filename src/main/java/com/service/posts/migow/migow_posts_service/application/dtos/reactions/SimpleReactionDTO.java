package com.service.posts.migow.migow_posts_service.application.dtos.reactions;

import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Reaction;

import lombok.Getter;

@Getter
public class SimpleReactionDTO {
    private final UUID id;
    private final String target;
    private final int type;
    private final UUID ownerId;

    public SimpleReactionDTO(Reaction r) {
        this.id = r.getId();
        this.target = r.getTarget();
        this.type = r.getType();
        this.ownerId = r.getOwner().getId();
    }
}
