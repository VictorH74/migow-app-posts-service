package com.service.posts.migow.migow_posts_service.application.dtos.reactions;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReactionDTO {
    private int type;
    private User owner;
}
