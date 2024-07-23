package com.service.posts.migow.migow_posts_service.application.dtos.users;

import java.io.Serializable;
import java.util.UUID;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * @return { id, username, name, profileImageUrl }
 */
@Getter
@Setter
@AllArgsConstructor
public class SimpleUserDTO implements Serializable {
    private UUID id;
    private String username;
    private String name;
    private String profileImageUrl;

    public SimpleUserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.profileImageUrl = user.getProfileImageUrl();
    }

    public User toUser() {
        User user = new User();

        user.setId(this.id);
        user.setUsername(this.username);
        user.setName(this.name);
        user.setProfileImageUrl(this.profileImageUrl);

        return user;
    }
}
