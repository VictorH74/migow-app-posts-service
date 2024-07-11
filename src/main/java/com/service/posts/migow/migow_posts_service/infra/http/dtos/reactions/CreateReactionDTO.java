package com.service.posts.migow.migow_posts_service.infra.http.dtos.reactions;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

public class CreateReactionDTO {
    private int type;
    private User owner;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
