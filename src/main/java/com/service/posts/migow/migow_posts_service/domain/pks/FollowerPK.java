package com.service.posts.migow.migow_posts_service.domain.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.domain.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class FollowerPK implements Serializable {
    @ManyToOne
    private User followerUser;
    @ManyToOne
    private User followedUser;

    public User getFollowerUser() {
        return followerUser;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    public void setFollowerUser(User followerUser) {
        this.followerUser = followerUser;
    }

    public void setFollowedUser(User followedUser) {
        this.followedUser = followedUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(followerUser, followedUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        FollowerPK other = (FollowerPK) obj;
        return Objects.equals(followerUser, other.followerUser) && Objects.equals(followedUser, other.followedUser);
    }
}
