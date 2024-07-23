package com.service.posts.migow.migow_posts_service.application.dtos.reactions;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReactionTypeCountsDTO implements Serializable {
    private Long likeReaction;
    private Long funnyReaction;
    private Long loveReaction;
    private Long sadReaction;
    private Long cuteReaction;
    private Long scaryReaction;

    public Long reactionTotal() {
        return likeReaction + funnyReaction + loveReaction + sadReaction + cuteReaction + scaryReaction;
    }
}
