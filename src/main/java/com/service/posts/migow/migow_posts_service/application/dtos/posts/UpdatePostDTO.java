package com.service.posts.migow.migow_posts_service.application.dtos.posts;

import java.util.Set;

import com.service.posts.migow.migow_posts_service.domain.entities.Media;

public class UpdatePostDTO {
    private String text;
    private Set<Media> mediaList;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(Set<Media> mediaList) {
        this.mediaList = mediaList;
    }

}
