package com.service.posts.migow.migow_posts_service.application.dtos.reactions;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUpdateReactionDTO {

    private UUID id;
    private int type;
    private UUID ownerId;
    private String targetType;
    private UUID targetId;
}
