package com.service.posts.migow.migow_posts_service.application.dtos.posts;

import java.util.Set;

import com.service.posts.migow.migow_posts_service.domain.entities.Media;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePostDTO {
    private String text;
    private Set<Media> mediaList;
}
