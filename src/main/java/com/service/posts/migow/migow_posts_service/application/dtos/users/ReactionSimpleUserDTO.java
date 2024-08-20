package com.service.posts.migow.migow_posts_service.application.dtos.users;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

import lombok.Getter;

@Getter
public class ReactionSimpleUserDTO extends SimpleUserDTO {
    private final int reactionType;

    public ReactionSimpleUserDTO(User user, int reactionType) {
        super(user);
        this.reactionType = reactionType;
    }

}
