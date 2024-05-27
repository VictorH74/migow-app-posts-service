package com.service.posts.migow.migow_posts_service.pks;

import java.io.Serializable;
import java.util.Objects;

import com.service.posts.migow.migow_posts_service.entities.Post;
import com.service.posts.migow.migow_posts_service.entities.User;

import jakarta.persistence.Embeddable;

@Embeddable
public class PostShareActivityRecordPK implements Serializable {
    private User user;
    private Post post;

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, post);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostShareActivityRecordPK other = (PostShareActivityRecordPK) obj;
        return Objects.equals(user, other.user) && Objects.equals(post, other.post);
    }

}
