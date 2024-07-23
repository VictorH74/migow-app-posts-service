package com.service.posts.migow.migow_posts_service.application.dtos.reactions;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReactionDTO {
    private int type;
    private UUID ownerId;
    private UUID targetId;
    private String targetClass;
}
