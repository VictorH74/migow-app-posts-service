package com.service.posts.migow.migow_posts_service.application.dtos.posts;

import java.util.Set;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.Media;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreatePostDTO {

    private UUID ownerId;
    private String text;
    private Set<Media> mediaList;
    private UUID sharedPost;
}
